new Vue({
    el:'#main-container',
    data:{
        appVersion:{}
    },
    methods:{
        doUpdate:function () {
            axios({
                url:'/manager/app/saveorupdate',
                method:'post',
                data:this.appVersion
            }).then(response=>{
                parent.layer.msg(response.data.msg);
                //关闭当前子窗口，先获取当前iframe窗口的索引
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            })
        }

    },
    created:function () {
        //获取父窗口传递的数据
        this.appVersion=parent.layer.appVersion
    }
})