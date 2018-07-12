(function () {

    var firstName = $('#firstName');
    var lastName = $('#lastName');
    var password = $('#password');
    var password2 = $('#password2');
    var username = $('#username');
    var role = $('#role');
    var phone = $('#phone');
    var emailAddress = $('#emailAddress');
    var date_of_birth = $('#date_of_birth');
    var registerBtn = jQuery('#registerBtn');
    registerBtn.click(createUser);
    var userServiceClient = new UserServiceClient();
    window.onload = function () {
        userServiceClient.findAllUsers().then(renderAllUsers);
        init();
    };

    function init() {
        firstName = $('#firstName');
        lastName = $('#lastName');
        password = $('#password');
        password2 = $('#password2');
        username = $('#username');
        role = $('#role');
        phone = $('#phone');
        emailAddress = $('#emailAddress');
        date_of_birth = $('#date_of_birth');
    }
