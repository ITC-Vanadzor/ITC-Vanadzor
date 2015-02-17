$(document).ready(function () {
    sellectAllOrNull();
    getEditUser();
});
//checked first checkbox: all select box in begin line make selected,
//and remove checked in first checkbox: all make no selected 
function sellectAllOrNull(){
    $('.tablePage .title li input[name="selectAll"]').click(function () {
        if (this.checked) {
            $('.tablePage ul li .checkUser').each(function () {
                    this.checked=true;
            });  
        }else{
            $('.tablePage ul li .checkUser').each(function () {
                    this.checked=false;
            });
        }
    });    
}

function getEditUser(){
    var value;
    var user_id;
    var rel;
    $('.action a').click(function(){
        $('.modal-content').html('<ul class="editUser"></ul>');
        user_id = $(this).parents('.user').find('li[rel="user_id"]').text();
        $('.editUser').append('<li style="display:none;"><input name="user_id" type="text" value="'+user_id+'" /></li>');
        $(this).parents('.user').find('div.text').each(function(){
            rel=$(this).parent().attr('rel');
            value = $(this).text();
            $('.editUser').append('<li><input type="text" class="text" value="'+value+'" name="'+rel+'"/></li>');
        });
        $('.modal-content').append('<button class="updateUser">Update</button>');
        updateUser();
    });
}
function updateUser(){
    $('button.updateUser').click(function(){
        updateArr=new Array();
        var user_id = $('.editUser li input[name="user_id"]').val()+"";
        $('.editUser li input.text').each(function(){
            updateArr[$(this).attr('name')]=$(this).val();
        });
        alert(updateArr.name);
    });
}