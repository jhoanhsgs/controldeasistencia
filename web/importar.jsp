<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Carga de datos</title>
    </head>
    <body>
        <div class="contenedorimport col-sm-12 col-md-12 col-lg-12 col-xl-12" >
            
            
             
                <h1>Carga de datos</h1>
                <form action="controlador?menu=Personas" method="POST">
                    
                    <div class="d-flex justify-content-center" id="file">
                        <h3 id="nombre"></h3><br>
                        <label for="archivo">Elegir Archivo</label>
                        <input type="file" name="archivo" id="archivo"/>
                    </div>
                    
                    
                    <div class="d-flex justify-content-center">
                        <input type="submit" name="accion" value="Cargar" class="carg"/>
                    </div>

                </form>
            
        </div>
        <script type="text/javascript">
            let archivo = document.querySelector('#archivo');
            archivo.addEventListener('change',() => {
                document.querySelector('#nombre').innerText = 
                        archivo.files[0].name;
            });
        </script>
    </body>
</html>
