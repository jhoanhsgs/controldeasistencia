$(document).ready(function () {
    $("button[name='registrarAsistencia']").click(function (e) {
        e.preventDefault();
        
        var date = document.querySelector('input[name="txtFecha"]').value;

        users = $(".table-active tr");
        values = ""
        for(var user of users){
            var id = user.querySelector('td[name="idPersona"]').innerText.trim();
            var state = user.querySelector('select').value;
            values = values + id+"-"+state+";";
        }
        var url = "controlador?menu=R_Asistencia&accion=Enviar Asistencia";
        
        

        var formData = {
            data: values,
            date: date
        };


        $.ajax({
            type: 'POST',
            url: url,
            data: formData,
            success: function (response, textStatus, xhr) {
                // La petición ha sido realizada con éxito
                var status = xhr.status;
                
                if (status === 200) {
                    // El código de respuesta es 200 (OK)
                    console.log('Petición realizada con éxito');
                    swal("Registrado!", "El usuario se ha registrado", "success")
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
        //

    });
});
