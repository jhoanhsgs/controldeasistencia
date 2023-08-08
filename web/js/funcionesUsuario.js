
$(document).ready(function () {
    $("tr #deleteUser").click(function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigo').val();

        swal({
            title: "Esta Seguro de Eliminar?",
            text: "Una vez eliminado deberá agregar de nuevo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sí, Eliminar!",
            cancelButtonText: "No, Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        cod ? eliminarUsuario(cod) : swal("Cancelado", "Cancelaste la eliminación", "error");
                        setTimeout(function () {
                            location.reload();
                        }, 1800);

                    } else {
                        swal("Cancelado", "Cancelaste la eliminación", "error");
                        //request.getRequestDispatcher("controlador?menu=Personas&accion=Listar").forward(request, response);
                    }
                });
    });

    $("#agUser").click(function (e) {
        e.preventDefault();

        var url2 = "controlador?menu=Personas&accion=Agregar";

        var formData = {
            txtCedula: $("#txtCedula").val(),
            txtNombre: $("#txtNombre").val(),
            txtApellido: $("#txtApellido").val(),
            txtEmail: $("#txtEmail").val(),
            rl: $("#rl").val(),
            txtExcusa: $("#txtExcusa").val()

        };


        $.ajax({
            type: 'POST',
            url: url2,
            data: formData,
            success: function (response, textStatus, xhr) {
                // La petición ha sido realizada con éxito
                var status = xhr.status;
                if (status === 200) {
                    // El código de respuesta es 200 (OK)
                    console.log('Petición realizada con éxito');
                    swal("Registrado!", "El usuario se ha registrado", "success");
                    setTimeout(function () {
                            location.reload();
                        }, 1800);
                } 
            },
            error: function (xhr, textStatus, errorThrown) {
                swal("Error", "Valida los datos!", "error");

                // La petición ha fallado
                console.log('Ha ocurrido un error');
            }
        });

        /*$.ajax({
         type: "POST",
         url: url2,
         data: formData,
         dataType: "json",
         encode: true,
         success: function (data, textStatus, http) {
         console.log("TTnTT");
         alert("Data: " + data + "\nTextStatus: " + textStatus + "\nHttpStatus: " + http.status);
         agregarUsuario();
         },
         error: ""
         });*/

        /*swal({
         title: "Esta Seguro de Eliminar?",
         text: "Una vez eliminado deberá agregar de nuevo!",
         type: "warning",
         showCancelButton: true,
         confirmButtonClass: "btn-danger",
         confirmButtonText: "Sí, Eliminar!",
         cancelButtonText: "No, Cancelar!",
         closeOnConfirm: false,
         closeOnCancel: false
         },
         function (isConfirm) {
         if (isConfirm) {
         cod ? eliminarUsuario(cod) : swal("Cancelado", "Cancelaste la eliminación", "error");
         setTimeout(function () {
         location.reload();
         }, 1800);
         
         } else {
         swal("Cancelado", "Cancelaste la eliminación", "error");
         //request.getRequestDispatcher("controlador?menu=Personas&accion=Listar").forward(request, response);
         }
         });*/
    });

    function agregarUsuario() {

        swal({
            type: "success",
            icon: 'success',
            title: 'Agregado con exito!',
            showConfirmButton: false,
            timer: 1500
        });
    }

    function eliminarUsuario(cod) {
        swal("Eliminado!", "El usuario se ha eliminado", "success");

        var url = "controlador?menu=Personas&accion=Eliminar&id=" + cod;
        console.log("eliminado - cod");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {

            }
        });
    }
});

