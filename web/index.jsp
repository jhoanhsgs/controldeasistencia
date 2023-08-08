<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link href="css/styleLogin.css" rel="stylesheet" type="text/css"/>
    <!-- Alertas -->
    <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
    
</head>
  <body>
    <div class="container">
      <div class="row justify-content-center pt-5 mt-5 mr-1">
        <div class="col-md-4">
          <div class="card-body text-center">
              <form name="login" class="form-sign" action="validar" method="POST">
                  <div class="user-img form-group">
                      <img src="img/portafolio.png"/>
                      <h2>Bienvenido al sistema</h2>
                      <hr>
                  </div>
                  <div class="form-group mx-sm-4">
                      <label>Usuario:</label>
                      <input type="text" name="txtuser" onkeypress="return " class="frm-control" placeholder="Ingresar su Usuario">
                  </div>
                  <div class="form-group mx-sm-4">
                      <label>Contraseña:</label>
                      <input type="password" name="txtpassword" class="frm-control" placeholder="Ingresar su Contraseña">
                  </div>
                  <input type="submit" name="accion" value="ingresar" class="btn btn-primary">
              </form>
          </div>
      </div>
    </div>
  </div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script src="css/alertify.min.js" type="text/javascript"></script>
<!-- Alertas -->

  </body>
</html>
