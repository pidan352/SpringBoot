new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            current: 1,
            size: 5
        },
        type: '',
        statute: {
            // title: '',
            // type: '',
            // pubDate: '',
            // stemFrom: '',
            // description: '',
        },
        ueditorConfig: {//自定义VueUeditorWrap配置项
            // ueditor.config.js 的UEDITOR_HOME_URL: "/static/ueditor/" ->
            // 覆盖为ueUeditorWrap的  UEDITOR_HOME_URL:"/static/UEditor/" (默认配置)   ->
            //覆盖为 ueditorConfig 的  UEDITOR_HOME_URL:"/ueditor/"          （自定义配置）
            UEDITOR_HOME_URL: "/ueditor/",  //前端资源默认读取路径  注意结束/不能省  是拼接
            // 服务器统一请求接口（服务器接口测试用，后修改为下面我们自己的服务器接口地址）
            // serverUrl:'http://35.201.165.105:8000/controller.php'
            serverUrl: '/ueditor/exec',
            maximumWords: 500000   /*设置支持最大编辑富文本字符个数*/
        }
    },
    methods: {
        selectAll: function (current, size) {
            axios({
                url: '/manager/statute/select/' + current + '/' + size,
                method: 'get',
            }).then(response => {
                if (response.data.code == 200) {
                    this.pageInfo = response.data.data
                }
            })
        },

        select: function (current, size) {
            axios({
                url: '/manager/statute/select/' + current + '/' + size,
                method: 'get',
                params: {
                    type: this.type
                }
            }).then(response => {
                if (response.data.code == 200) {
                    this.pageInfo = response.data.data
                }
            })
        },

        toUpdate: function (statute_id) {
            axios({
                url: '/manager/statute/selectOne',
                params: {id: statute_id}
            }).then(response => {
                if (response.data.code != 200) {
                    layer.msg(response.data.msg)
                    return
                }

                //弹消息框(app-update.html)
                layer.obj = response.data.data;
                //打开layer所在的页面
                var index = layer.open({
                    type: 2,
                    title: '更新信息',
                    content: '/manager/statute/statute-update.html',
                    area: ['75%', '75%'],
                    //关闭页面执行的操作
                    end: () => {
                        this.select(this.pageInfo.current, this.pageInfo.size)
                    }
                })
            })
        },

        save: function () {
            _statute = this.statute

            console.log(this.statute.description)
            axios({
                url: '/manager/statute/saveOrUpdate',
                method: 'post',
                data: _statute,
            }).then(response => {
                if (response.data.code == 200) {
                    //更新表格，更新data中的数据即可
                    this.selectAll(this.pageInfo.current, this.pageInfo.size)
                    //让添加的那个表格显示的数据恢复初始状态
                    this.statute = {}
                }
                layer.msg(response.data.msg,{offset:'852px',top:'652px'})
            }).catch(error => {
                layer.msg(error.data)
            })
        },

        doDelete: function (statute_id) {
            axios({
                url: '/manager/statute/delete',
                method: 'get',
                params: {
                    id: statute_id
                }
            }).then(response => {
                if (response.data.code == 200) {
                    this.selectAll(this.pageInfo.current, this.pageInfo.size)
                }
                layer.msg(response.data.msg)
            })
        }

    },
    created: function () {
        this.selectAll(1, 5)
    },
    /*vue组件属性，用于引入一些已经封装好的vue组件对象*/
    components: {
        VueUeditorWrap
    },
    mounted:function(){
        jeDate({
            dateCell: '#indate',
            format: 'YYYY-MM-DD',
            zIndex: 999999999,
            choosefun: val  => { //注意jeDate函数中的this是jeDate对象，需要使用箭头函数转换this为vue上下文
                //选中日期后的回调(查看jedate.js源码195行可以看到config对象使用文档)
                // val:组件中的日期数据
                //由于该组件生成的input的值是直接js写入到dom节点的，并不是vue双向绑定的，需要通过事件来给data中的statute的日期赋值
                this.statute.pubDate = val;
            }
        });
    }

})