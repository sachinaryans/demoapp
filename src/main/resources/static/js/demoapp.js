function pageFunctions(){
var parent = document.getElementsByClassName("detailCollapsible");

        for (var m = 0; m < parent.length; m++) {
            parent[m].addEventListener("click", function () {
                this
                    .classList
                    .toggle("detailActive");
                var content = this.nextElementSibling;
                if (content.style.display === "block") {
                    content.style.display = "none";
                } else {
                    content.style.display = "block";
                }
            });
        }
        var parentNav = document.getElementsByClassName("navCollapsible");
        for (var m = 0; m < parentNav.length; m++) {
            var navContentList = parentNav[m]
                .nextElementSibling
                .getElementsByClassName("navContent");
            for (var i = 0; i < navContentList.length; i++) {
                var status = navContentList[i].style.backgroundColor;
                if (status === "rgb(198, 5, 25)" || status === "rgb(198, 5, 25)") {
                    parentNav[m].style.backgroundColor = "#c60519";
                    break;
                }
            }
        }

        for (var m = 0; m < parentNav.length; m++) {
            parentNav[m].addEventListener("click", function () {
                this
                    .classList
                    .toggle("down");
                var navContentList = this
                    .nextElementSibling
                    .getElementsByClassName("navContent");
                for (var i = 0; i < navContentList.length; i++) {
                    var content = navContentList[i];
                    if (content.style.display === "block") {
                        content.style.display = "none";
                    } else {
                        content.style.display = "block";
                    }
                }
            });
        }
        var navContentList = document.getElementsByClassName("navContent");
        for (var m = 0; m < navContentList.length; m++) {
            navContentList[m].addEventListener("click", function () {
                for (var i = 0; i < navContentList.length; i++) {
                    navContentList[i]
                        .classList
                        .remove('active');
                }
                this
                    .classList
                    .add('active');
                var elementId = "detail_" + this.id;
                var testCase = this.innerText;
				 getEmployee();
                var detailDiv = document.getElementById(elementId);
				var detailScriptLsit = document.getElementsByClassName("detailScript");
                for (var i = 0; i < detailScriptLsit.length; i++) {
					detailScriptLsit[i].style.display = "none";
				}
                if (detailDiv.style.display === "block") {
                    detailDiv.style.display = "none";
                    document
                        .getElementById('stepDetails')
                        .style
                        .display = "none";
                } else {
                   
                    document
                        .getElementById('contentLoading')
                        .style
                        .display = "block";
                    detailDiv.style.display = "block";
                    detailDiv.style.opacity = "0.3";
                    setTimeout(function () {
                        displayContent(detailDiv);
                    }, 500);

                }
            });
        }
        

        function displayContent(detailDiv) {
            document
                .getElementById('contentLoading')
                .style
                .display = "none";
            detailDiv.style.display = "block";
            detailDiv.style.opacity = "1";
        }
}
        $(document).ready(function(){
pageFunctions();
           
          
          });
        function getEmployee(){
            $.ajax({
                method:"get",
                url: "http://localhost:8080/employees/",
                Accept: "application/json",
                headers: {
                    'Content-Type':'application/json'
                },
                async: false,           // <-- This is the key
                success: function (data) {
                    console.log(data.employeeList[0].firstName);
					var dataText="";
                    for (let index = 0; index < data.employeeList.length; index++) {
                        dataText=dataText+'<tr><td>'+data.employeeList[index].firstName+'</td><td>'+data.employeeList[index].sex+'</td><td>'+data.employeeList[index].dob+'</td><td>'+data.employeeList[index].email+'</td><td>'+data.employeeList[index].carCompany+'</td></tr>';
                        
                    }
					$('#empTable').find('tbody').html(dataText);
                },
                error: function (err) {
                    console.log(err);
                }
            });
        }
		
		function postEmployee(){
			var fname = $('#fname').val();
			var sname = $('#sname').val();
			var group1 = $("input[name='group1']:checked").val();
			var DOB = $('#DOB').val();
			var email = $('#email').val();
			var cars = $('#cars').val();
			
			var text = '{"firstName":"'+fname+'","lastName":"'+sname+'","email":"'+email+'","salutation":"","dob":"'+DOB+'","sex":"'+group1+'","carCompany":"'+cars+'"}';
			var data1 = JSON.parse(text);
            $.ajax({
                method:"post",
                url: "http://localhost:8080/employees/",
	            headers: {
                    'Content-Type':'application/json',
					'X-COM-PERSIST':'application/json'
                },
				dataType:'text',
				data: text,
                async: false,           // <-- This is the key
                success: function (data) {
				alert(data);               
				},
                error: function (err) {
                    console.log(err);
                }
            });
        }
		function saveMethod(){
		alert("saved");
		}
			
        