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

    function createUser() {
        firstName = firstName.val();
        lastName = lastName.val();
        password = password.val();
        password2 = password2.val();
        username = username.val();
        role = role.val();
        phone = phone.val();
        emailAddress = emailAddress.val();
        date_of_birth = date_of_birth.val();
        if (password2 != null && password2 != undefined && password2 != "" && password != password2) {
            init();
            alert("password does't match");
        } else {
            userServiceClient.registerHandler(firstName, lastName, password, password2,
                username, role, phone, emailAddress, date_of_birth);
            init();
        }
    }

    function renderAllUsers(users) {
        var tableData = "";
        for (var i = 0; i < users.length; i++) {
            tableData += "<tr>";
            tableData += "<td><input id=firstName" + users[i].id + " value=" + users[i].firstName + " input/></td>";
            tableData += "<td><input id=lastName" + users[i].id + " value=" + users[i].lastName + " input/></td>";
            tableData += "<td><input type='password' id=password" + users[i].id + " value=" + users[i].password + " input/></td>";
            tableData += "<td><input id=username" + users[i].id + " value=" + users[i].username + " input/></td>";
            tableData += "<td><select id=role" + users[i].id + ">";
            if (users[i].role == "Faculty") {
                tableData += "<option value='Faculty' selected='selected'> Faculty</option>";
            } else {
                tableData += "<option value='Faculty'> Faculty</option>";
            }
            if (users[i].role == "Student") {
                tableData += "<option value='Student' selected='selected'> Student</option>";
            } else {
                tableData += "<option value='Student'> Student</option>";
            }
            if (users[i].role == "Admin") {
                tableData += "<option value='Admin' selected='selected'> Admin</option>";
            } else {
                tableData += "<option value='Admin'> Admin</option>";
            }
            tableData += "</select></td>";
            tableData += "<td><input type='tel' id=phone" + users[i].id + " value=" + users[i].phone + " input/></td>";
            tableData += "<td><input type='email' id=emailAddress" + users[i].id +
                " value=" + users[i].emailAddress + " input/></td>";
            tableData += "<td><input type='date' id=date_of_birth" + users[i].id +
                " value=" + users[i].date_of_birth.toString().substring(0, 10) + " input/></td>";
            tableData += "<td>" + users[i].id + "</td>";
            tableData += "<td><button id=u" + users[i].id + " class='btn btn-primary' onclick=JavaScript:updateUser(" + users[i].id + ");>Update</button>" +
                "<button id=d" + users[i].id + " class='btn btn-primary' onclick=JavaScript:deleteUser(" + users[i].id + ");>Delete</button>";
            tableData += "</td>";
            tableData += "</tr>";
        }
        $('#userTable').html(tableData);
    }
})();

