let noticeApp = new Vue({
    el:"#noticeApp",
    data:{
        notice:{}
    },
    methods:{
        findNoticeById:function () {
            let qid=location.search;
            qid=qid.substring(1);
            $.ajax({
                url:"/findNotice",
                method:"get",
                data:{
                    id:qid
                },
                success:function (r) {
                    console.log(r);
                    if(r.code==OK){
                        noticeApp.notice=r.data;
                        console.log(noticeApp.notice)
                    }
                }

            })
        }
    },
    created:function () {
        this.findNoticeById();
    }
})