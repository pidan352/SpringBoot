new Vue({
    el: '#app'
    , data: {
        stuList: []  //所有学生的数组
        , stu: {}      //单个学生的对象
        , checkIds: []  //存放被选中的id数组
    }
    , methods: {
        findAll: function () {
            var _this = this;
            axios({
                url: '/findAll'
                , method: 'get'
                //在axios中，this已经改成window对象，有下面两种解决方案
            }).then(function (response) {
                _this.stuList = response.data;

                // }).then(responce => {
                //     this.stuList = responce.data;   //在axios中，自动封装成：data:[]
            }).catch(function (error) {
                console.log(error.message);
            })
        },

        toUpdate: function (obj) {
            $.extend(true,this.stu,obj)
            console.log(this.stu)
            $("#myModal").show();
        },

        doUpdate: function () {
            axios({
                url: 'update'
                , method: 'post'
                , data: this.stu
            }).then(response => {
                if (response.data) {
                    alert("更新成功")
                    this.findAll();
                } else {
                    alert("更新失败")
                }
            }).catch(error => {
                alert("出现错误:" + error.message)
            })
            $("#myModal").hide();
        },

        closewindow: function () {
            $("#myModal").hide();
        },

        checkstudent: function (e, id) {
            //判断是否被选中
            if (e.target.checked) {
                alert(id)
                this.checkIds.push(id);
            } else {
                //从数组中移除
                var index = this.checkIds.indexOf(id)
                this.checkIds.splice(index, 1)
            }
        },

        doDelete: function () {
            if (confirm("确认删除？")) {
                axios({
                    url: 'removeByIds?ids='+this.checkIds
                    , method: 'post'
                }).then(response => {
                    if (response.data) {
                        alert("删除成功");
                        this.findAll();
                    } else {
                        alert("删除失败");
                    }
                }).catch(error => {
                    alert(error.message);
                })
            }
        }
    }
    , created: function () {
        this.findAll()
    }
})