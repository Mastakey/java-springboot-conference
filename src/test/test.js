var jq = document.createElement('script');
jq.src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js";
document.getElementsByTagName('head')[0].appendChild(jq);
// ... give time for script to load, then type (or see below for non wait option)
jQuery.noConflict();
$ = jQuery;

//GET
$.get('/speakers', function(data){
    console.log(data);
})

//PUT
$.ajax({
    url: '/speakers/2',
    type: 'PUT',
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify({ "speaker_id": 2, "first_name": "Kioh", "last_name": "Han", "title": "Engineer", "company": "DTCI", "speaker_bio": "Test2" }),
    success: function (result) {
        console.log(result);
    }
});

//POST
var data = {
     "first_name": "Lily", 
     "last_name": "Han", 
     "title": "Child", 
     "company": "Home", 
     "speaker_bio": "Lily is a Tiger" 
};
$.ajax({
    url: '/speakers',
    type: 'POST',
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify(data),
    success: function (result) {
        console.log(result);
    }
});

//DELETE
$.ajax({
    url: '/speakers/43',
    type: 'DELETE',
    success: function (result) {
        console.log(result);
    }
});

//Exception Handling

//GET
$.get('/speakers/99', function(data){
    console.log(data);
}).fail(function(data){
    console.log(data.responseJSON.message);
})

//PUT bad id
$.ajax({
    url: '/speakers/99',
    type: 'PUT',
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify({ "first_name": "Kioh", "last_name": "Han", "title": "Engineer", "company": "DTCI", "speaker_bio": "Test2" }),
}).fail(function(xhr, status, error) {
	console.log(xhr.responseJSON);
});

//bad request
$.ajax({
    url: '/speakers/2',
    type: 'PUT',
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify({ "first_name": "Kioh", "last_name": "Han", "title": "Engineer", "company": "DTCI" }),
}).fail(function(xhr, status, error) {
	console.log(xhr.responseJSON);
});

//POST bad request
var data = {
    "first_name": "Lily", 
    "last_name": "Han", 
    "title": "Child"
};
$.ajax({
   url: '/speakers',
   type: 'POST',
   contentType: "application/json",
   dataType: "json",
   data: JSON.stringify(data)
}).fail(function(xhr, status, error){
    console.log(xhr.responseJSON);
});

//DELETE bad id
$.ajax({
    url: '/speakers/99',
    type: 'DELETE',
    success: function (result) {
        console.log(result);
    }
}).fail(function(xhr, status, error) {
	console.log(xhr.responseJSON);
});