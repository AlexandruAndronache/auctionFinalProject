
var errorLineStart = "<p class = 'error'></p>";

$(document).ready(function () {


    $("form#register_form button").click(function () {
        const firstName = $("form input#firstName").val();
        const lastName = $("form input#lastName").val();
        const email = $("form input#email").val();
        const password = $("form#register_form input#password").val();
        const confirmPassword = $("form#register_form input#confirmPassword").val();

        const userDto = JSON.stringify( { firstName, lastName, email, password});
        console.log("Hello! " + userDto);
    });

    $.ajax( {
        url: "http://localhost:8080/api/register",
        dataType: 'json',

    })

});