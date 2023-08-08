
$(document).ready(function () {
    $("tr #deleteFicha").click(function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigoF').val();

        swal({
            title: "Esta Seguro de Eliminar la Ficha?",
            text: "Una vez eliminado deberá agregar de nuevo nada!",
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
                        cod ? eliminarFicha(cod) : swal("Cancelado", "Cancelaste la eliminación", "error");
                        setTimeout(function () {
                            location.reload();
                        }, 1800);

                    } else {
                        swal("Cancelado", "Cancelaste la eliminación", "error");
                        //request.getRequestDispatcher("controlador?menu=Personas&accion=Listar").forward(request, response);
                    }
                });
    });
    $("#agFicha").click(function (e) {
        e.preventDefault();

        var url2 = "controlador?menu=Ficha&accion=Agregar";

        var formData = {
            txtNFicha: $("#txtNFicha").val(),
            txtFechaIni: $("#txtFechaIni").val(),
            txtFechaFin: $("#txtFechaFin").val(),
            program: $("#program").val()


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

        
    });

    function eliminarFicha(cod) {
        swal("Eliminado!", "El usuario se ha eliminado", "success");

        var url = "controlador?menu=Ficha&accion=Eliminar&id=" + cod;
        
        console.log("eliminado - codF");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {

            }
        });
    }
    
    function agregarFicha() {

        swal({
            type: "success",
            icon: 'success',
            title: 'Agregado con exito!',
            showConfirmButton: false,
            timer: 1500
        });
    }
    
    
});

