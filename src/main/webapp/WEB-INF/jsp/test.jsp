<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>

<body>
    <div id = "tasks">
        <a href="http://192.168.1.14:8080/login">TEST</a>
    </div>
    <button id='button'>OK</button>
    <button id ='Post'>POST</button>
    <input name="_csrf" id = 'csrf'/>
</body>
<script>
	xhr = new XMLHttpRequest();
    var url = '192.168.1.14'
    button = document.getElementById('button')
    button.addEventListener('click', function () {
        xhr.open('GET', 'http://'+url+':8080/api/tasks', true);
        xhr.send()
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var res = xhr.responseText;
                divElem = document.getElementById('tasks')
                res = JSON.parse(res);
                var h3Elem = document.createElement('h3');
                for(var i = 0; i<res.length; i++){
                    var obj = res[i]
                    var id = document.createTextNode(obj.id+"");
                    h3Elem.appendChild(id);
                    divElem.appendChild(h3Elem);
                }
            }
        }
    });
	$(function () {
		  var token = $("meta[name='_csrf']").attr("content");
		  var header = $("meta[name='_csrf_header']").attr("content");
		  $(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader(header, token);
		  });
		});

    post_button = document.getElementById('Post');
    post_button.addEventListener('click', function(){
    	var task = {
             'hours' : 4,
             'description': "this is a test task.",
             'assignedOn': "3,4",
             'completed': false
         };
    	  $.ajax({
    	        type: "POST",
    	        url: "http://"+url+':8080/api/tasks',
    	        data: task,
    	        contentType: "application/json; charset=utf-8",
    	        dataType: "json",
    	        success: function(){alert('Success');},
    	        failure: function(errMsg) {
    	            alert(errMsg);
    	        }
    	  });
    });
//         xhr = new XMLHttpRequest();
//         xhr.open('POST','http://'+url+':8080/api/tasks',true);
//         xhr.setRequestHeader('Content-Type','application/json');
//         
//         xhr.setRequestHeader('XSRF-TOKEN',getMyToken());
//         xhr.send(JSON.stringify(task));
//         xhr.onreadystatechange = function(){
// 				if (xhr.readyState == 4 && xhr.status == 200){
// 					alert('Task Added!');
// 				};
// 			}
//     });
//     document.getElementById('csrf').value = getMyToken()
//     function getMyToken() {
//     var cookies = document.cookie;
//     return cookies.replace('XSRF-TOKEN=','');

</script>

</html>