new Vue({
    el: '#main-container',
    data: {
        //分页数据及查询到的app集合数据。字段不给全，之后接受数据时也会有相应的字段
        pageInfo: {
            current: 1,
            size: 5
        },
        //添加功能的表格的初始数据
        app: {
            platform: 0,
            forceUpdate: 0
        },
        active: false

    },
    methods: {
        //查询数据，将其放到data中的pageInfo存储
        select: function (pageNum, pageSize) {
            axios({
                url: '/manager/app/select',
                params: {
                    current: pageNum,
                    size: pageSize
                }
            }).then(response => {
                this.pageInfo = response.data.data
            })
        },

        //添加一条记录
        save: function () {
            _app = this.app;
            axios({
                url: '/manager/app/saveorupdate',
                method: 'post',
                data: _app,
            }).then(response => {
                if (response.data.code == 200) {
                    //更新表格，更新data中的数据即可
                    this.select(this.pageInfo.current, this.pageInfo.size)
                    //让添加的那个表格显示的数据恢复初始状态
                    this.app = {
                        platform: 0,
                        forceUpdate: 0
                    }
                }
                layer.msg(response.data.msg)
            }).catch(error => {
                layer.msg(error.data)
            })
        },

        //弹出修改窗口,这里使用的是另一个页面，实际上用同一个弹出模态窗口比较好，减少麻烦
        toUpdate: function (app_id) {
            axios({
                url: "/manager/app/selectOne",
                method: 'get',
                params: {
                    id: app_id
                }
            }).then(response => {
                if (response.data.code != 200) {
                    layer.msg(response.data.msg)
                    return
                }

                //弹消息框(app-update.html)
                layer.appVersion = response.data.data;
                //打开layer所在的页面
                var index = layer.open({
                    type: 2,
                    title: '更新信息',
                    content: '/manager/app/app-update.html',
                    area: ['60%', '60%'],
                    //关闭页面执行的操作
                    end: () => {
                        this.select(this.pageInfo.current, this.pageInfo.size)
                    }
                })

            })
        },

        //删除一条记录
        doDelete: function (app_id) {
            layer.msg('是否删除', {
                //无自动消失计时
                time: 0,
                btn: ['是', '否'],
                yes: index => {
                    axios({
                        url: '/manager/app/doDelete',
                        method: 'get',
                        params: {
                            id: app_id
                        }
                    }).then(response => {
                        if (response.data.code == 200) {
                            this.select(this.pageInfo.current, this.pageInfo.size)
                        }
                        layer.msg(response.data.msg)
                        layer.close(index)
                    })
                }
            })

        }

    },
    created: function () {
        this.select(this.pageInfo.current, this.pageInfo.size)
    }

})