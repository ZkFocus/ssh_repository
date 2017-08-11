  $(function(){  
        $('#dg').datagrid({    
                 title:'用户管理',    
                 iconCls:'icon-edit',//图标    
                 width: 530,    
                 height: 300,    
                 nowrap: false,    
                 striped: true,    
                 border: true,    
                 toolbar:'#toolbar' , //你试试没有这行 看看什么效果
               //  fit: true,//自动大小    
                 url:'user-list',    
                 //sortName: 'code',    
                 //sortOrder: 'desc',    
                 remoteSort:false,     
                 idField:'id',    
                 singleSelect:true,//是否单选    
                 rownumbers:true//行号    
             });  
            
        });  
 
    
    var url;
    function newUser() {
        $('#dlg').dialog('open').dialog('setTitle', 'New User');
        $('#fm').form('clear');
        url='addUser';
       // $('#dlg').dialog('close')
    }
    function editUser() {
        var row = $('#tt').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('setTitle', 'Edit User');
            $('#fm').form('load', row);
            url = 'editUser';
        }
    }
    function saveUser() {
        $('#fm').form('submit', {
            url: url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(result) {
                var result = eval('(' + result + ')');
                if (result.errorMsg) {   //保存的时候 检查json里有没有errorMsg
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {
                    $('#dlg').dialog('close'); // close the dialog
                    $('#tt').datagrid('reload'); // reload the user data
                }
            }
        });
    }
    function destroyUser() {
        var row = $('#tt').datagrid('getSelected');  //得到我选择的那一行
        if (row) {
            $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?',
            function(r) {
                if (r) {
                    $.post('deleteUser', {
                        id: row.userId         //这个userid就是 jsp里面的那个 field="userId"
                    },
                    function(result) {
                        if (result.success) {  //删除的时候 检查json里有没有success这个域
                            $('#tt').datagrid('reload'); // reload the user data
                        } else {
                            $.messager.show({ // show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        }
                    },
                    'json');
                }
            });
        }
    } 