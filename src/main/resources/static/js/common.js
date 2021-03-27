/**
 *引用公共组件
 */
var _hmt = _hmt || [];
(function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?5b8572ca1660965974d2ea9f755f0459";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();

$(document).ready(function () {
    $("#header").load('common/header.html');
    $("#footer").load('common/footer.html');
})


var EventUtil = {
    addHandler: function (element, type, handler) {
        if (element.addEventListener)
            element.addEventListener(type, handler, false);
        else if (element.attachEvent) element.attachEvent("on" + type, handler);
        else element["on" + type] = handler;
    },
    removeHandler: function (element, type, handler) {
        if (element.removeEventListener)
            element.removeEventListener(type, handler, false);
        else if (element.detachEvent) element.detachEvent("on" + type, handler);
        else element["on" + type] = handler;
    },
    /**
     * @param target 要绑定监听的目标元素
     * @param isPreventDefault 是否屏蔽掉触摸滑动的默认行为（例如页面的上下滚动，缩放等）
     * @param upCallback 向上滑动的监听回调（若不关心，可以不传，或传false）
     * @param rightCallback 向右滑动的监听回调（若不关心，可以不传，或传false）
     * @param downCallback 向下滑动的监听回调（若不关心，可以不传，或传false）
     * @param leftCallback 向左滑动的监听回调（若不关心，可以不传，或传false）*/
    listenTouchDirection: function (target, isPreventDefault, upCallback, rightCallback, downCallback, leftCallback) {
        this.addHandler(target, "touchstart", handleTouchEvent);
        this.addHandler(target, "touchend", handleTouchEvent);
        this.addHandler(target, "touchmove", handleTouchEvent);
        var startX;
        var startY;

        function handleTouchEvent(event) {
            switch (event.type) {
                case "touchstart":
                    startX = event.touches[0].pageX;
                    startY = event.touches[0].pageY;
                    break;
                case "touchend":
                    var spanX = event.changedTouches[0].pageX - startX;
                    var spanY = event.changedTouches[0].pageY - startY;
                    if (Math.abs(spanX) > Math.abs(spanY)) { //认定为水平方向滑动
                        if (spanX > 30) { //向右
                            if (rightCallback) {
                                rightCallback();
                            }

                        } else if (spanX < -30) { //向左
                            if (leftCallback) {
                                leftCallback();
                            }
                        }
                    } else { //认定为垂直方向滑动
                        if (spanY > 30) { //向下
                            if (downCallback) {
                                downCallback();
                            }
                        } else if (spanY < -30) {//向上
                            if (upCallback) {
                                upCallback();
                            }
                        }
                    }
                    break;
                case "touchmove": //阻止默认行为
                    if (isPreventDefault) event.preventDefault();
                    break;
            }
        }
    }
}


//古城景点页面数据
const publicityData={
    interval:null,//轮播图循环
    moving:false,//当前是否在翻页
    // 轮播图上一张
    prevTo:(that)=>{
        if(publicityData.moving){
            return false
        }
        clearInterval(publicityData.interval);
        publicityData.moving = true;
        let nowLeft = Number($(that).parent().attr("data-left"))*10000; //当前left
        let len = Number($(that).parent().attr("data-len")); //目标轮播图的图片总数
        let orderLeft = nowLeft+ 55500; //目标移动位置
        publicityData.interval = setInterval(()=>{
            nowLeft = nowLeft +500;
            $(that).parent().find(".publicity-imglist").css("left",nowLeft/10000+'rem');
            if(nowLeft == orderLeft){
                publicityData.moving = false;
                $(that).parent().attr("data-left",orderLeft/10000);
                if(orderLeft ==0){ //移动到第一张图时
                    $(that).parent().find(".publicity-imglist").css("left",-len*5.55+'rem');
                    $(that).parent().attr("data-left",-len*5.55);
                }
                clearInterval(publicityData.interval);
            }
        },1)

    },
    // 轮播图下一张
    nextTo:(that)=>{
        if(publicityData.moving){
            return false
        }
        clearInterval(publicityData.interval);
        publicityData.moving = true;
        let nowLeft = Number($(that).parent().attr("data-left"))*10000;
        let len = Number($(that).parent().attr("data-len"));
        let orderLeft = nowLeft - 55500;
        publicityData.interval = setInterval(()=>{
            nowLeft = nowLeft  - 500;
            $(that).parent().find(".publicity-imglist").css("left",nowLeft/10000+'rem');
            if(nowLeft == orderLeft){
                publicityData.moving = false;
                $(that).parent().attr("data-left",orderLeft/10000);
                if(orderLeft/10000 ==(-(len+1)*5.55)){//移动到最后一张图时
                    $(that).parent().find(".publicity-imglist").css("left",'0rem');
                    $(that).parent().attr("data-left",0);
                }
                clearInterval(publicityData.interval);
            }
        },1)
    },
    //凤凰九景taber切换
    changeNav:(index,that)=>{
        $(".publicity-nav li").removeClass("publicity-nav-active");
        $(that).addClass("publicity-nav-active");
        $(".publicity-item").eq(0).find('.publicity-li').removeClass("publicity-li-active");
        $(".publicity-item").eq(0).find('.publicity-li').eq(index).addClass("publicity-li-active");
    }
}

// 吃喝玩乐事件
const productData={
    //轮播图上一页
    prevPage:(that)=>{
        $(that).parent().find(".product-live-ul").append($(that).parent().find('.product-live-item').eq(0))
    },
    //轮播图下一页
    nextPage:(that)=>{
        $(that).parent().find(".product-live-ul").prepend($(that).parent().find('.product-live-item').eq($(that).parent().find('.product-live-item').length-1))
    },
    showTip:(that)=>{
        $(that).next(".product-live-tip").css("top",0)
    },
    hideTip:(that)=>{
        $(that).css("top","100%")
    }
}

// 古城概述事件
const aboutData={
    //轮播图上一页
    moving:false,
    interval:null,//轮播图循环
    interval2:null,
    prevPage:(that)=>{

        $(that).parent().find(".celebrity-ul").append($(that).parent().find('.celebrity-item').eq(0))
    },
    //轮播图下一页
    nextPage:(that)=>{
        clearTimeout(aboutData.interval);
        // clearInterval(aboutData.interval2);
        aboutData.moving  = true;
        // let totallPdR = 90;
        // aboutData.interval2 = setInterval(function(){
        // 	totallPdR = totallPdR-1;
        // 	$(that).parent().find(".celebrity-ul").css("padding-right",totallPdR/100+'rem');
        // 	if(totallPdR ==0){
        // 		console.log(totallPdR)
        // 		clearInterval(aboutData.interval2)
        // 	}

        // },10)

        $(that).parent().find(".celebrity-ul").prepend($(that).parent().find('.celebrity-item').eq($(that).parent().find('.celebrity-item').length-1));
        aboutData.interval = setTimeout(function(){
            aboutData.moving = false;
        },1000)
    },
    showTip:(that)=>{
        $(that).next(".celebrity-tip").css("top",0)
    },
    hideTip:(that)=>{
        $(that).css("top","100%")
    }
}

