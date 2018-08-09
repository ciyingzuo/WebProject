(function () {

    var userServiceClient = new UserServiceClient();
    var id = 0;
    var updateBtn = jQuery('#updateUser');
    updateBtn.click(updateUser);
    loginCheck().then(listUser);

    function loginCheck() {
        return fetch('/loginCheck', {'credentials': 'include'}).then(function (response) {
            return response.json();
        });
    }

    function listUser(user) {
        id = user.id;
        $username = $('#username');
        $firstName = $('#firstName');
        $lastName = $('#lastName');
        $password = $('#password');
        $phone = $('#phone');
        $emailAddress = $('#emailAddress');
        $date_of_birth = $('#date_of_birth');
        $username.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lastName);
        $password.val(user.password);
        $phone.val(user.phone);
        $emailAddress.val(user.emailAddress);
        $date_of_birth.val(user.date_of_birth.toString().substring(0, 10));
    }

    function updateUser() {
        var firstName = $('#firstName');
        firstName = firstName.val();
        var lastName = $('#lastName');
        lastName = lastName.val();
        var password = $('#password');
        password = password.val();
        var username = $('#username');
        username = username.val();
        var role = $('#role');
        role = role.val();
        var phone = $('#phone');
        phone = phone.val();
        var emailAddress = $('#emailAddress');
        emailAddress = emailAddress.val();
        var date_of_birth = $('#date_of_birth');
        date_of_birth = date_of_birth.val();
        userServiceClient.updateUser(id, firstName, lastName, password,
            username, role, phone, emailAddress, date_of_birth);
    }
})();