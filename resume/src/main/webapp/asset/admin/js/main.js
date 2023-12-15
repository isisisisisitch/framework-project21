function addValidatorRules(form, handler) {
    $(form).validate({
        highlight: function (input) {
            $(input).parents('.form-line').addClass('error')
        },
        unhighlight: function (input) {
            $(input).parents('.form-line').removeClass('error')
        },
        errorPlacement: function (error, element) {
            let $parent = $(element).parents('.input-group').append(error)
            if (!$parent.hasClass('.form-group')) {
                $(element).parents('.form-group').append(error)
            }
        },
        submitHandler: handler
    })
}

// 密码
// $.validator.addMethod('password',
//     value =>  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/.test(value),
//     '8-16位（至少1个大写字母、1个小写字母、1个数字）')

$(function () {
    $('.form-control[autofocus]').focus()
})