let sideApp = new Vue({//挂载在侧边栏的Vue
    el: "#sideApp",
    data: {},
    methods: {
        sideClick: function (status) {//侧边栏轮播图点击事件(更改主体标签内容)
            bodyApp.sideStatus=status;
            if(status===1){//轮播图CRUD
                console.log("轮播图CRUD");
                $.ajax({
                    url: "/banners",
                    data:{
                    },
                    method:"Get",
                    success: function (r) {
                        console.log("banners:"+r);
                        if(r.code==OK) {
                            bodyApp.banners = r.data;
                        }
                    }

                })
            }else if(status===2){//票务CRUD
                console.log("景区活动CRUD");
            }else if(status===3){//普通用户账户管理
                console.log("用户CRUD");
                $.ajax({
                    url:"/users",
                    method:"get",
                    success:function (r) {
                        console.log("users:"+r)
                        if (r.code == 0) {
                            bodyApp.users = r.data;
                        }
                    }
                })
            }
        },
    },
    created:function () {
        $.ajax({
            url: "/banners",
            data:{
            },
            method:"Get",
            success: function (r) {
                console.log("banners:"+r);
                if(r.code==OK) {
                    bodyApp.banners = r.data;
                }
            }

        })
    }

})