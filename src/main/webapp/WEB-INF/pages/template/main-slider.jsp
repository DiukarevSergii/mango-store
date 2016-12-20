<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="slider">
    <!-- #region Slider Begin -->
    <!-- This code works with jquery library. -->
    <script src="/resources/bootstrap/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="/resources/bootstrap/js/jssor.slider-22.0.3.mini.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {

            var jssor_1_SlideoTransitions = [
                [{b: 0, d: 600, y: -290, e: {y: 27}}],
                [{b: 0, d: 1000, y: 185}, {b: 1000, d: 500, o: -1}, {b: 1500, d: 500, o: 1}, {
                    b: 2000,
                    d: 1500,
                    r: 360
                }, {b: 3500, d: 1000, rX: 30}, {b: 4500, d: 500, rX: -30}, {b: 5000, d: 1000, rY: 30}, {
                    b: 6000,
                    d: 500,
                    rY: -30
                }, {b: 6500, d: 500, sX: 1}, {b: 7000, d: 500, sX: -1}, {b: 7500, d: 500, sY: 1}, {
                    b: 8000,
                    d: 500,
                    sY: -1
                }, {b: 8500, d: 500, kX: 30}, {b: 9000, d: 500, kX: -30}, {b: 9500, d: 500, kY: 30}, {
                    b: 10000,
                    d: 500,
                    kY: -30
                }, {b: 10500, d: 500, c: {x: 87.50, t: -87.50}}, {b: 11000, d: 500, c: {x: -87.50, t: 87.50}}],
                [{b: 0, d: 600, x: 410, e: {x: 27}}],
                [{b: -1, d: 1, o: -1}, {b: 0, d: 600, o: 1, e: {o: 5}}],
                [{b: -1, d: 1, c: {x: 175.0, t: -175.0}}, {
                    b: 0,
                    d: 800,
                    c: {x: -175.0, t: 175.0},
                    e: {c: {x: 7, t: 7}}
                }],
                [{b: -1, d: 1, o: -1}, {b: 0, d: 600, x: -570, o: 1, e: {x: 6}}],
                [{b: -1, d: 1, o: -1, r: -180}, {b: 0, d: 800, o: 1, r: 180, e: {r: 7}}],
                [{b: 0, d: 1000, y: 80, e: {y: 24}}, {
                    b: 1000,
                    d: 1100,
                    x: 570,
                    y: 170,
                    o: -1,
                    r: 30,
                    sX: 9,
                    sY: 9,
                    e: {x: 2, y: 6, r: 1, sX: 5, sY: 5}
                }],
                [{b: 2000, d: 600, rY: 30}],
                [{b: 0, d: 500, x: -105}, {b: 500, d: 500, x: 230}, {b: 1000, d: 500, y: -120}, {
                    b: 1500,
                    d: 500,
                    x: -70,
                    y: 120
                }, {b: 2600, d: 500, y: -80}, {b: 3100, d: 900, y: 160, e: {y: 24}}]
            ];

            var jssor_1_options = {
                $AutoPlay: true,
                $Idle: 4000,
                $CaptionSliderOptions: {
                    $Class: $JssorCaptionSlideo$,
                    $Transitions: jssor_1_SlideoTransitions,
                    $Breaks: [
                        [{d: 2000, b: 1000}]
                    ]
                },
                $ArrowNavigatorOptions: {
                    $Class: $JssorArrowNavigator$
                },
                $BulletNavigatorOptions: {
                    $Class: $JssorBulletNavigator$
                }
            };

            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);
        });
    </script>
    <style>
        /* jssor slider bullet navigator skin 01 css */
        /*
        .jssorb01 div           (normal)
        .jssorb01 div:hover     (normal mouseover)
        .jssorb01 .av           (active)
        .jssorb01 .av:hover     (active mouseover)
        .jssorb01 .dn           (mousedown)
        */
        .jssorb01 {
            position: absolute;
        }

        .jssorb01 div, .jssorb01 div:hover, .jssorb01 .av {
            position: absolute;
            /* size of bullet element */
            width: 12px;
            height: 12px;
            filter: alpha(opacity=70);
            opacity: .7;
            overflow: hidden;
            cursor: pointer;
            border: #000 1px solid;
        }

        .jssorb01 div {
            background-color: gray;
        }

        .jssorb01 div:hover, .jssorb01 .av:hover {
            background-color: #d3d3d3;
        }

        .jssorb01 .av {
            background-color: #fff;
        }

        .jssorb01 .dn, .jssorb01 .dn:hover {
            background-color: #555555;
        }

        /* jssor slider arrow navigator skin 02 css */
        /*
        .jssora02l                  (normal)
        .jssora02r                  (normal)
        .jssora02l:hover            (normal mouseover)
        .jssora02r:hover            (normal mouseover)
        .jssora02l.jssora02ldn      (mousedown)
        .jssora02r.jssora02rdn      (mousedown)
        .jssora02l.jssora02lds      (disabled)
        .jssora02r.jssora02rds      (disabled)
        */
        .jssora02l, .jssora02r {
            display: block;
            position: absolute;
            /* size of arrow element */
            width: 55px;
            height: 55px;
            cursor: pointer;
            background: url('/resources/img/slider/a02.png') no-repeat;
            overflow: hidden;
        }

        .jssora02l {
            background-position: -3px -33px;
        }

        .jssora02r {
            background-position: -63px -33px;
        }

        .jssora02l:hover {
            background-position: -123px -33px;
        }

        .jssora02r:hover {
            background-position: -183px -33px;
        }

        .jssora02l.jssora02ldn {
            background-position: -3px -33px;
        }

        .jssora02r.jssora02rdn {
            background-position: -63px -33px;
        }

        .jssora02l.jssora02lds {
            background-position: -3px -33px;
            opacity: .3;
            pointer-events: none;
        }

        .jssora02r.jssora02rds {
            background-position: -63px -33px;
            opacity: .3;
            pointer-events: none;
        }
    </style>
    <div id="jssor_1"
         style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 1000px; height: 343px; overflow: hidden; visibility: hidden;">
        <!-- Loading Screen -->
        <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
            <div style="position:absolute;display:block;background:url('/resources/img/slider/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
        </div>
        <div data-u="slides"
             style="cursor: default; position: relative; top: 0px; left: 0px; width: 1000px; height: 343px; overflow: hidden;">
            <div data-p="112.50">
                <a href="/product-${meizu_id}">
                    <img data-u="image" src="/resources/img/slider/meizu-mx6-slider-1000x343.jpg"/>
                </a>
                <div data-u="caption" data-t="0"
                     style="position:absolute;top:320px;left:620px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    Надежней, чем в банке
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/iphone-6s-slider-1000x343.jpg"/>
                <div data-u="caption" data-t="1" data-3d="1"
                     style="position:absolute;top:-50px;left:125px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    Резиновые цены
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/gift-2017-slider-1000x343-v3.jpg"/>
                <div data-u="caption" data-t="2"
                     style="position:absolute;top:30px;left:-380px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    Это то что ты искал
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/samsung-20yoP2-slider-1000x343-ru.jpg"/>
                <div data-u="caption" data-t="3"
                     style="position:absolute;top:30px;left:30px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    20 лет не шутки
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/ipad-gift-on-ny-slider-1000x343-v3.jpg"/>
                <div data-u="caption" data-t="4"
                     style="position:absolute;top:30px;left:30px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.6);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    Подарочки
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/macbook-gift-on-ny-slider-1000x343-v3.jpg"/>
                <div data-u="caption" data-t="5"
                     style="position:absolute;top:30px;left:1000px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    Всё и так ясно
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/samsung-galaxy-tabpro_s-adapter-v_podarok-1000x343.jpg"/>
                <div data-u="caption" data-t="6"
                     style="position:absolute;top:30px;left:30px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    БЕРИСЬ! ЭТО БОМБА!!
                </div>
            </div>
            <div data-b="0" data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/zagrebolog-slider-1000x343.jpg"/>
                <div data-u="caption" data-t="7"
                     style="position:absolute;top:-50px;left:30px;width:350px;height:30px;z-index:0;
                     background-color:rgba(235,81,0,0.5);font-size:20px;color:#ffffff;line-height:30px;text-align:center;">
                    Я уже гребу! А ты?
                </div>
            </div>
            <div data-p="112.50" style="display: none;">
                <img data-u="image" src="/resources/img/slider/vmeste-deshevle-fitnes-trecker--1000x343.jpg"/>
                <div data-u="caption" data-t="8" data-3d="1"
                     style="position:absolute;top:25px;left:150px;width:250px;height:250px;z-index:0;
                     background-color:rgba(40,177,255,0.6); overflow: hidden;">
                    <div data-u="caption" data-t="9"
                         style="position:absolute;top:100px;left:25px;width:200px;height:50px;z-index:0;font-size:24px;line-height:50px;">
                        Будь в форме
                    </div>
                </div>
            </div>
        </div>
        <!-- Bullet Navigator -->
        <div data-u="navigator" class="jssorb01" style="bottom:16px;right:16px;">
            <div data-u="prototype" style="width:12px;height:12px;"></div>
        </div>
        <!-- Arrow Navigator -->
        <span data-u="arrowleft" class="jssora02l" style="top:0px;left:8px;width:55px;height:55px;"
              data-autocenter="2"></span>
        <span data-u="arrowright" class="jssora02r" style="top:0px;right:8px;width:55px;height:55px;"
              data-autocenter="2"></span>
    </div>
    <!-- #endregion Slider End -->
</div>