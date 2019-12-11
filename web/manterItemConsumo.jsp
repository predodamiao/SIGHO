<!--
=========================================================
* * Black Dashboard - v1.0.1
=========================================================

* Product Page: https://www.creative-tim.com/product/black-dashboard
* Copyright 2019 Creative Tim (https://www.creative-tim.com)


* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<%@page contentType="text/html" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="iso-8859-1"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" type="image/png" href="./assets/img/favicon.png">
        <title>
            SIGHO - Item de Consumo
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet"/>
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- Nucleo Icons -->
        <link href="./assets/css/nucleo-icons.css" rel="stylesheet"/>
        <!-- CSS Files -->
        <link href="./assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet"/>
    </head>

    <body class="">
        <div class="wrapper">
            <div class="sidebar" data="green" id="sidebar">
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="javascript:void(0)" class="simple-text fa-2x logo-mini">
                            <i class="tim-icons icon-puzzle-10"></i>
                        </a>
                        <a href="javascript:void(0)" class="simple-text logo-normal">
                            Recepção
                        </a>
                    </div>
                    <ul class="nav">
                        <li>
                            <a href="PesquisaHospedeController">
                                <i class="tim-icons icon-single-02"></i>
                                <p>Hóspede</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaReservaController">
                                <i class="tim-icons icon-delivery-fast"></i>
                                <p>Reserva</p>
                            </a>
                        </li>
                        <li>
                            <a href="RealizarCheckinController?acao=prepararCheckin">
                                <i class="tim-icons icon-basket-simple"></i>
                                <p>Check-In</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaHospedagensAtivasController">
                                <i class="tim-icons icon-single-02"></i>
                                <p>Check-out</p>
                            </a>
                        </li>

                    </ul>
                </div>

                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="javascript:void(0)" class="simple-text fa-2x logo-mini">
                            <i class="tim-icons icon-puzzle-10"></i>
                        </a>
                        <a href="javascript:void(0)" class="simple-text logo-normal">
                            Controle
                        </a>
                    </div>
                    <ul class="nav">
                        <li>
                            <a href="PesquisaConsumoController">
                                <i class="tim-icons icon-basket-simple"></i>
                                <p>Consumo</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaPrestacaoServicoController">
                                <i class="tim-icons icon-delivery-fast"></i>
                                <p>Prestação Servico</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaAtendimentoRestauranteController">
                                <i class="tim-icons icon-molecule-40"></i>
                                <p>Atendimento Restaurante</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaPagamentoController">
                                <i class="tim-icons icon-wallet-43"></i>
                                <p>Pagamento</p>
                            </a>
                        </li>

                    </ul>
                </div>


                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="javascript:void(0)" class="simple-text fa-2x logo-mini">
                            <i class="tim-icons icon-puzzle-10"></i>
                        </a>
                        <a href="javascript:void(0)" class="simple-text logo-normal">
                            Gerencia
                        </a>
                    </div>
                    <ul class="nav">
                        <li>
                            <a href="PesquisaItemConsumoController">
                                <i class="tim-icons icon-bag-16"></i>
                                <p>Item de Consumo</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaItemFrigobarController">
                                <i class="tim-icons icon-app"></i>
                                <p>Item do Frigobar</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaOpcaoRestauranteController">
                                <i class="tim-icons icon-molecule-40"></i>
                                <p>Opção do Restaurante</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaTipoQuartoController">
                                <i class="tim-icons icon-bullet-list-67"></i>
                                <p>Tipo de Quarto</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaQuartoController">
                                <i class="tim-icons icon-key-25"></i>
                                <p>Quarto</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaServicoController">
                                <i class="tim-icons icon-delivery-fast"></i>
                                <p>Servico</p>
                            </a>
                        </li>
                        <li>
                            <a href="PesquisaFuncionarioController">
                                <i class="tim-icons icon-single-02"></i>
                                <p>Funcionário</p>
                            </a>
                        </li>

                    </ul>
                </div>

                <br>


            </div>


            <div class="main-panel" data="green">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent" data="green">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle d-inline">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="index.jsp" style="margin-top:15px;"><h6 class="fa-4x"
                                                                                                  style="color:#FFFFFF">
                                    SIGHO</h6></a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navigation">
                            <ul class="navbar-nav ml-auto">

                                <li class="dropdown nav-item">
                                    <a href="#">
                                        <div class="photo">
                                            <img src="./assets/img/anime3.png" alt="Profile Photo">
                                        </div>
                                    </a>

                                </li>
                                <li class="separator d-lg-none"></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class="modal modal-search fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="SEARCH">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <i class="tim-icons icon-simple-remove"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Navbar -->
                <div class="content" id="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title fa-2x"> ITEM DE CONSUMO - ${operacao}</h4>
                                </div>
                                <div class="card-body">
                                    <form action="ManterItemConsumoController?acao=confirmarOperacao&operacao=${operacao}"
                                          method="post">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="codigo">Código</label>
                                                    <input class="form-control" type="text" name="codigo" id="codigo"
                                                           value="${itemConsumo.codigo}" <c:if test="${operacao != 'Incluir'}">
                                                               readonly </c:if> required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="nome">Nome</label>
                                                        <input class="form-control" type="text" name="nome" id="nome"
                                                               value="${itemConsumo.nome}" <c:if test="${operacao == 'Excluir'}">
                                                            readonly </c:if> required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="descricao">Descrição</label>
                                                        <textarea rows="1" cols="80" class="form-control" name="descricao"
                                                                  id="descricao" <c:if
                                                            test="${operacao == 'Excluir'}"> readonly </c:if>required>${itemConsumo.descricao}</textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="preco">Preço</label>
                                                        <input class="form-control" type="number" name="preco" id="preco"
                                                               step="0.01" min="0.00" value="${itemConsumo.precoVenda}" <c:if
                                                            test="${operacao == 'Excluir'}"> readonly </c:if> required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card-footer">
                                                <button type="submit" class="btn btn-fill btn-primary">${operacao}</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <footer class="footer">
                    <div class="container-fluid">
                        <ul class="nav">
                            <li class="nav-item">
                                Lavínia Beghini e Pedro Henrique Damião
                            </li>
                        </ul>
                        <div class="copyright">
                            ©
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            SIGHO
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <!--   Core JS Files   -->
        <script src="./assets/js/core/jquery.min.js"></script>
        <script src="./assets/js/core/popper.min.js"></script>
        <script src="./assets/js/core/bootstrap.min.js"></script>
        <script src="./assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="./assets/js/black-dashboard.min.js?v=1.0.0"></script>

        <script>

                                $(document).ready(function () {
                                    var tamanho = $("#sidebar").height();

                                    $("#content").css('min-height', tamanho);

                                    $().ready(function () {
                                        $sidebar = $('.sidebar');
                                        $navbar = $('.navbar');
                                        $main_panel = $('.main-panel');

                                        $full_page = $('.full-page');

                                        $sidebar_responsive = $('body > .navbar-collapse');
                                        sidebar_mini_active = true;
                                        white_color = false;

                                        window_width = $(window).width();

                                        fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

                                        $('.fixed-plugin a').click(function (event) {
                                            if ($(this).hasClass('switch-trigger')) {
                                                if (event.stopPropagation) {
                                                    event.stopPropagation();
                                                } else if (window.event) {
                                                    window.event.cancelBubble = true;
                                                }
                                            }
                                        });

                                        $('.fixed-plugin .background-color span').click(function () {
                                            $(this).siblings().removeClass('active');
                                            $(this).addClass('active');

                                            var new_color = $(this).data('color');

                                            if ($sidebar.length != 0) {
                                                $sidebar.attr('data', new_color);
                                            }

                                            if ($main_panel.length != 0) {
                                                $main_panel.attr('data', new_color);
                                            }

                                            if ($full_page.length != 0) {
                                                $full_page.attr('filter-color', new_color);
                                            }

                                            if ($sidebar_responsive.length != 0) {
                                                $sidebar_responsive.attr('data', new_color);
                                            }
                                        });

                                        $('.switch-sidebar-mini input').on("switchChange.bootstrapSwitch", function () {
                                            var $btn = $(this);

                                            if (sidebar_mini_active == true) {
                                                $('body').removeClass('sidebar-mini');
                                                sidebar_mini_active = false;
                                                blackDashboard.showSidebarMessage('Sidebar mini deactivated...');
                                            } else {
                                                $('body').addClass('sidebar-mini');
                                                sidebar_mini_active = true;
                                                blackDashboard.showSidebarMessage('Sidebar mini activated...');
                                            }

                                            // we simulate the window Resize so the charts will get updated in realtime.
                                            var simulateWindowResize = setInterval(function () {
                                                window.dispatchEvent(new Event('resize'));
                                            }, 180);

                                            // we stop the simulation of Window Resize after the animations are completed
                                            setTimeout(function () {
                                                clearInterval(simulateWindowResize);
                                            }, 1000);
                                        });

                                        $('.switch-change-color input').on("switchChange.bootstrapSwitch", function () {
                                            var $btn = $(this);

                                            if (white_color == true) {

                                                $('body').addClass('change-background');
                                                setTimeout(function () {
                                                    $('body').removeClass('change-background');
                                                    $('body').removeClass('white-content');
                                                }, 900);
                                                white_color = false;
                                            } else {

                                                $('body').addClass('change-background');
                                                setTimeout(function () {
                                                    $('body').removeClass('change-background');
                                                    $('body').addClass('white-content');
                                                }, 900);

                                                white_color = true;
                                            }


                                        });

                                        $('.light-badge').click(function () {
                                            $('body').addClass('white-content');
                                        });

                                        $('.dark-badge').click(function () {
                                            $('body').removeClass('white-content');
                                        });
                                    });
                                });
        </script>

    </body>

</html>