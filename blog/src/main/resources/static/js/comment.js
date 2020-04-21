/*点击恢复按钮，发送ajax请求*/
function postcomment() {
    /*获取页面中的问题的id*/
    var questionId = $("#question_id").val();
    /*获取页面中的问题的评论内容*/
    var comment = $("#comment").val();
    /*发送ajax请求*/
    $.ajax({
        /*类型*/
        type:"POST",
        /*请求地址*/
        url:"/comment",
        /*请求的类型*/
        contentType:"application/json",
        /*请求的数据，JSON格式;JSON.stringify()方法讲对象序列化为json对象*/
        data:JSON.stringify({
            "parentId":questionId,
            "content":comment,
            "type":1
        }),
        /*请求成功返回调用方法*/
        success:function (response) {
            /*如果请求返回200，为成功，将问题也的回复框部分隐藏*/
            if (response.code == 200){
                $("#content_id").hide();
            }else {
                /*请求失败，弹窗提示失败的信息*/
                alert(response.message);
            }

        }
    });
}