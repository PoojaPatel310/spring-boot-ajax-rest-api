 $(document).ready(function(){
            $("#bookForm").submit(function(event){
                event.preventDefault();
                ajaxPost();
                });
                function ajaxPost(){
                var formData={
                id= $("#id").val(),
                id= $("#title").val(),
                id= $("#author").val(),
                id= $("#price").val(),

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url:"/api/books/saveBook",
                    data.JSON.stringify(formData),
                    dataType: "json",
                    success: function(result){
                        if(result.status == "success")
                        {
                                $("#postResultDiv").html(""+result.data.title+" Successfully Added !!<br>")
                        }
                        else{
                          $("#postResultDiv").html("Error")
                        }
                        console.log(result);
                    },
                    error: function(e){
                        alert("Error!")
                        console.log("Error",e);
                    }
                });
            }

        }
      )