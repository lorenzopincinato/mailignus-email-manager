function paginaDestino(urlPagina) {
  $(window.parent.document).find('#meuFrame').addClass('animated fadeOut').one('webkitAnimationEnd',
    function() {
      $(window.parent.document).find('#meuFrame').hide();
      $(window.parent.document).find('#meuFrame').removeClass('animated fadeOut');

      if (urlPagina == 'entrar.html') {
        $(window.parent.document).find('#meuFrame').css('height', '244px');
      } else if (urlPagina == 'cadastrar.html') {
        $(window.parent.document).find('#meuFrame').css('height', '293px');
      } else if (urlPagina == 'alterarUsuario.html') {
        $(window.parent.document).find('#meuFrame').css('height', '323px');
      } else if (urlPagina == 'alterarSenha.html') {
        $(window.parent.document).find('#meuFrame').css('height', '373px');
      }

      $(window.location).attr('href', urlPagina);

      $(window.parent.document).find('#meuFrame').ready(
        function (){
          $(window.parent.document).find('#meuFrame').show();

          $(window.parent.document).find('#meuFrame').addClass('animated fadeIn').one('webkitAnimationEnd',
            function() {
              $(window.parent.document).find('#meuFrame').removeClass('animated fadeIn');
            });
        });
    });

  $(window.parent.document).find('#logoMailignus').addClass('animated pulse').one('webkitAnimationEnd',
    function() {
      $(window.parent.document).find('#logoMailignus').removeClass('animated pulse');
    });
}


function estadoFormulario(urlAtual, estado) {
  var urlDestino = '';
  var mensagem = '';
  $(window.parent.document).find('#meuFrame').addClass('animated fadeOut').one('webkitAnimationEnd',
    function() {
      $(window.parent.document).find('#meuFrame').hide();
      $(window.parent.document).find('#meuFrame').removeClass('animated fadeOut');

      if (urlAtual == 'entrar.html') {
        $(window.parent.document).find('#meuFrame').css('height', '244px');
        urlDestino = urlAtual;
        mensagem = 'Usuário e/ou senha inválido(s).'
        
      } else if (urlAtual == 'cadastrar.html' && estado == true) {
        $(window.parent.document).find('#meuFrame').css('height', '244px');
        urlDestino = 'entrar.html';
        mensagem = 'O usuário foi cadastrado.'
      } else if (urlAtual == 'cadastrar.html' && estado == false) {
        $(window.parent.document).find('#meuFrame').css('height', '293px');
        urlDestino = urlAtual;
        mensagem = 'O usuário já existe.';
        
      } else if (urlAtual == 'alterarUsuario.html' && estado == true) {
        $(window.parent.document).find('#meuFrame').css('height', '244px');
        urlDestino = 'entrar.html';
        mensagem = 'O usuário foi alterado.';
      } else if (urlAtual == 'alterarUsuario.html'&& estado == false) {
        $(window.parent.document).find('#meuFrame').css('height', '323px');
        urlDestino = urlAtual;
        mensagem = 'O usuário já existe e/ou senha inválida.';
      }
      
      else if (urlAtual == 'alterarSenha.html' && estado == true) {
        $(window.parent.document).find('#meuFrame').css('height', '244px');
        urlDestino = 'entrar.html'
        mensagem = 'A senha foi alterada.';
      } else if (urlAtual == 'alterarSenha.html' && estado == false) {
        $(window.parent.document).find('#meuFrame').css('height', '373px');
        urlDestino = urlAtual;
        mensagem = 'Usuário e/ou senha inválido(s).';
      }

      $(window.location).attr('href', urlDestino);

      $(window.parent.document).find('#meuFrame').ready(
        function (){
          $(window.parent.document).find('#meuFrame').show();

          $(window.parent.document).find('#meuFrame').addClass('animated fadeIn').one('webkitAnimationEnd',
            function() {
              $(window.parent.document).find('#meuFrame').removeClass('animated fadeIn');
              
              if (estado == true)
                alertaSucesso.warning(mensagem);
              else
                alertaErro.warning(mensagem);
            });
        });
    });

  $(window.parent.document).find('#logoMailignus').addClass('animated pulse').one('webkitAnimationEnd',
    function() {
      $(window.parent.document).find('#logoMailignus').removeClass('animated pulse');
    });
}


alertaSucesso = function() {}
alertaSucesso.warning = function(message) {
    $(window.parent.document).find('#meuFrame').contents().find('#divAlerta').html('<div id="divAlerta" class="alert alert-success alert-dismissable animated fadeIn"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Sucesso! </strong>' + message + '</div>');
}

alertaErro = function() {}
alertaErro.warning = function(message) {
    $(window.parent.document).find('#meuFrame').contents().find('#divAlerta').html('<div id="divAlerta" class="alert alert-danger alert-dismissable animated fadeIn"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Erro! </strong>' + message + '</div>');
}