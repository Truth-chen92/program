let bodyApp = new Vue({//挂载在内容主体的Vue
    el: "#bodyApp",
    data: {
        sideStatus:1,
        banners:[],
        insertBannerFormStatus:0,
        users:[],

        title:'',
        dynamic:0,
        notices:[],


    },
    methods:{
        showInsertBannerForm:function(id){
            this.insertBannerFormStatus=id;
        },
        insertBanner:function (sortNum) {
            console.log("insertBanner:");
            let files =document.getElementById("imageFile"+sortNum).files;
            console.log("files.length:"+files.length);
            if(files.length>0){
                let file=files[0];
                console.log(file);
                uploadImage(file,sortNum);
            }else{
                alert("请选择要上传的文件!!!");//如果用户没选中文件,给与提示
                return;
            }
        },
        deleteBanner:function (id) {
            console.log("deleteBanner");
            $.ajax({
                url:"/deleteBanner",
                data:{
                    id:id
                },
                method: "get",
                success:function (r) {
                    console.log("deleteBanner:"+r.code);
                    sideApp.sideClick(1);//执行方法，目的是遍历轮播图
                }
            })
        },
        createContent:function(){
            let content = $('#summernote').val();
            console.log(content);
            //data 对象，与服务器端QuestionVo的属性对应
            let data = {
                title:bodyApp.title,
                dynamic: bodyApp.dynamic,
                content:content
            };
            console.log(data);
            $.ajax({
                url:'/saveNotice',
                traditional: true,  //采用传统数组编码方式，SpringMVC才能接收
                method:'POST',
                data:data,
                success:function (r) {
                    console.log(r);
                    if(r.code == OK){
                        console.log(r.message+"okokokok");
                        $('#refreshButton').trigger("click");
                        bodyApp.title="";
                        $("#summernote").summernote("reset");
                    }else{
                        console.log(r.message);
                    }
                }
            });
        },
    },
    created:function () {
        $.ajax({
            url:'/notices',
            traditional: true,  //采用传统数组编码方式，SpringMVC才能接收
            method:'get',
            success:function (r) {
                console.log(r);
                if(r.code == 0){
                    bodyApp.notices=r.data;
                }else{
                    console.log(r.message);
                }
            }
        })
    }
})
function uploadImage(file,sortNum){
    let form=new FormData();
    //将用户上传的文件,追加到表单中imageFile就是它的name属性
    form.append("imageFile",file);
    form.append("sortNum",sortNum)
    $.ajax({
        url:"/addBanner",
        method:"post",
        data: form,
        //文件上传时必须编写的两个属性设置
        contentType:false,
        processData:false,
        success:function(r){
            if(r.code==OK){
                bodyApp.banners=r.data;
                bodyApp.insertBannerFormStatus=0;
            }else{
                alert(r.message);
            }
            $("#imageFile").val("");
        }
    });
}