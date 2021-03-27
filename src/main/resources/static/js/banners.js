let bannersApp = new Vue({
    el:".bannersApp",
    data: {
      banners:[],
      isFirst:false,
      isFirst2:false
    },
    methods:{
        loadBanners:function () {
            $.ajax({
                url: "/banners",
                data:{

                },
                method:"Get",
                success: function (r) {
                    console.log("banners:"+r);
                    if(r.code==OK) {
                        bannersApp.banners = r.data;
                    }
                }
            })
        },
        first:function (index) {
            if(index==0){
                this.isFirst = true;
            }
            else{
                this.isFirst=false;
            }
            return true;
        },
        first2:function (index) {
            if(index==0){
                this.isFirst2 = true;
            }
            else{
                this.isFirst2 = false;
            }
            return true;
        }
    },
    created:function () {
        this.loadBanners();
    }
})