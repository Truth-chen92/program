layui.use('table', function(){
    var table = layui.table;
    //监听表格复选框选择
    table.on('checkbox(user)', function(obj){
        console.log(obj)
    });
    //监听工具条
    table.on('tool(user)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){//点击查看
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){//点击删除
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    url:"/deleteUser",
                    data:{
                        id:data.id
                    },
                    method:"get",
                    success:function (r) {
                        if (r.code == OK){
                            obj.del();
                            layer.close(index);
                        }
                    }
                })
            });
        } else if(obj.event === 'edit'){//点击编辑
            layer.alert('查看json数据：<br>'+ JSON.stringify(data))
        }
    });

    var $ = layui.$, active = {
        getCheckData: function(){ //获取选中数据
            var checkStatus = table.checkStatus('idUser')
                ,data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        }
        ,getCheckLength: function(){ //获取选中数目
            var checkStatus = table.checkStatus('idUser')
                ,data = checkStatus.data;
            layer.msg('选中了：'+ data.length + ' 个');
        }
        ,isAll: function(){ //验证是否全选
            var checkStatus = table.checkStatus('idUser');
            layer.msg(checkStatus.isAll ? '全选': '未全选')
        }
    };

    $('.userTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

});