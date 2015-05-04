/**
 * Created by tugba on 04.05.2015.
 */

var urlHolder = new Object();

function loadTable() {
    $.get(urlHolder.records, function(response) {

        $('#tablePersons').find('tbody').remove();

        for (var i=0; i<response.persons.length; i++) {
            var row = '<tr>';
            row += '<td><input type="radio" name="index" id="index" value="'+i+'"></td>';
            row += '<td>' + response.persons[i].id + '</td>';
            row += '<td>' + response.persons[i].firstName + '</td>';
            row += '<td>' + response.persons[i].lastName + '</td>';
            row += '<td>' + response.persons[i].phone + '</td>';
            row += '</tr>';
            $('#tableUsers').append(row);
        }

        $('#tablePersons').data('model', response.persons);
        toggleForms('hide'); ;
    });
}

function submitNewRecord() {
    $.post(urlHolder.add, {
            id: $('#newId').val(),
            firstName: $('#newFirstName').val(),
            lastName: $('#newLastName').val(),
            phone: $('#newPhone').val()
        },
        function(response) {
            if (response != null) {
                loadTable();
                toggleForms('hide'); ;
                toggleCrudButtons('show');
                alert('Success! Record has been added.');
            } else {
                alert('Failure! An error has occurred!');
            }
        }
    );
}

function submitDeleteRecord() {
    var selected = $('input:radio[name=index]:checked').val();

    $.post(urlHolder.del, {
            id: $('#tablePersons').data('model')[selected].id
        },
        function(response) {
            if (response == true) {
                loadTable(urlHolder.records);
                alert('Success! Record has been deleted.');
            } else {
                alert('Failure! An error has occurred!');
            }
        }
    );
}

function submitUpdateRecord() {
    $.post(urlHolder.edit, {
            id: $('#editId').val(),
            firstName: $('#editFirstName').val(),
            lastName: $('#editLastName').val(),
            phone: $('#editPhone').val()
        },
        function(response) {
            if (response != null) {
                loadTable();
                toggleForms('hide'); ;
                toggleCrudButtons('show');
                alert('Success! Record has been edited.');
            } else {
                alert('Failure! An error has occurred!');
            }
        }
    );
}



function hasSelected() {
    var selected = $('input:radio[name=index]:checked').val();
    if (selected == undefined) {
        alert('Select a record first!');
        return false;
    }

    return true;
}

function fillEditForm() {
    var selected = $('input:radio[name=index]:checked').val();
    $('#editId').val( $('#tablePersons').data('model')[selected].id );
    $('#editFirstName').val( $('#tablePersons').data('model')[selected].firstName );
    $('#editLastName').val( $('#tablePersons').data('model')[selected].lastName );
    $('#editPhone').val( $('#tablePersons').data('model')[selected].phone );
}

function resetNewForm() {
    $('#newId').val('');
    $('#newFirstName').val('');
    $('#newLastName').val('');
    $('#newPhone').val('');
}

function resetEditForm() {
    $('#editFirstName').val('');
    $('#editLastName').val('');
    $('#editPhone').val('');
}

function toggleForms(id) {
    if (id == 'hide') {
        $('#newForm').hide();
        $('#editForm').hide();

    } else if (id == 'new') {
        resetNewForm();
        $('#newForm').show();
        $('#editForm').hide();

    } else if (id == 'edit') {
        resetEditForm();
        $('#newForm').hide();
        $('#editForm').show();
    }
}

function toggleCrudButtons(id) {
    if (id == 'show') {
        $('#newBtn').removeAttr('disabled');
        $('#editBtn').removeAttr('disabled');
        $('#deleteBtn').removeAttr('disabled');
        $('#reloadBtn').removeAttr('disabled');

    } else if (id == 'hide'){
        $('#newBtn').attr('disabled', 'disabled');
        $('#editBtn').attr('disabled', 'disabled');
        $('#deleteBtn').attr('disabled', 'disabled');
        $('#reloadBtn').attr('disabled', 'disabled');
    }
}