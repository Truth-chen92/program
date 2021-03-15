const API={
	commomUrl:"https://api-cms.xisland.cn/api", // 公共前缀url
	commomUrl2:"https://xclub.xisland.cn", // 公共前缀url
	ajax:(url, type, params, beforefn,successfn,errorfn,st)=>{//ajax封装

		$.ajax({
            url: (st?API.commomUrl2:API.commomUrl) + url,
            type: type,
            headers:{ // 公共header
		        "Content-Type": "application/x-www-form-urlencoded"
		    },
            data: params,
            beforeSend:function(xhr){
               if(st) xhr.setRequestHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwianRpIjoiN2UzODMzNDMtMzVhYS00NWRiLThlNjUtZjI0Mjg2MTVhZTUxIiwiY2xpZW50X2lkIjoibWFsbCIsInNjb3BlIjpbImFsbCJdfQ.XHIjLGR4lB3TFxocf5cdKmqCKn12RU1Xlzu570gh4ac");
                // console.log('看需要写不写,发送前的就是放加载图标的地方,这里显示,success和error函数里就隐藏');
            },
            success: function (res) {
                successfn(res)
            },
            error: function (res) {
                errorfn(res)            },
            complete:function(){
                // console.log('结束 看需要写不写');
            }
        });
	},
	//获取攻略列表
	getTips:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/tips","GET",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取攻略详情
	getTipDetail:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/tips/"+data.tip_id,"GET",{},beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取动态列表
	getTrends:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/trends","GET",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取动态详情
	getTrendDetail:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/trends/"+data.trend_id,"GET",{},beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取活动列表
	getActivities:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/activities","GET",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取活动详情
	getActivityDetail:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/activities/"+data.activity_id,"GET",{},beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//活动报名
	applyActivity:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/activities/users","POST",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取公告列表
	getAnnouncements:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/announcements","GET",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取公告详情
	getAnnouncementDetail:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/announcements/"+data.announcement_id,"GET",{},beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})
	},
	//获取天气数据
	getWeather:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/mall/weather","GET",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)},true)
		})
	},
	//登录接口
	login:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/member/login","POST",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)},true)
		})
	},
	//获取验证码
	getCode:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/member/verify-code","POST",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)},true)
		})
	},
	//查看当前用户是否报名
	getUserMessage:(beforefn,data)=>{
		return new Promise((resolve, reject) =>{
			API.ajax("/web/activities/user","GET",data,beforefn,res=>{
				resolve(res)
			},error=>{reject(error)})
		})		
	}
}