<div id="calendar"></div>

<script>
    $(document).ready(function() {
        $.getJSON("/p2groep04-javaweb/planning/get.htm", function(data){
            console.log(data);
        })
        /*$.ajax({
            url: "/p2groep04-javaweb/planning/get.htm",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            //data: JSON.stringify({ name: "Gerry", age: 20, city: "Sydney" }), //Stringified Json Object
            async: false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false, //This will force requested pages not to be cached by the browser          
            processData: false, //To avoid making query String instead of JSON
            success: function(resposeJsonObject) {
                console.log(resposeJsonObject);
            },
            error: function(request, status, err) {
                console.log("error");
                console.log(request.responseText);
                console.log(status.responseText);
                console.log(err.responseText);
            }
        });*/
    });
</script>