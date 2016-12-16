﻿(function (j, f, c, i, d, l, g) {
    new (function () {
    });
    var e = j.$JssorEasing$ = {
        $EaseSwing: function (a) {
            return -c.cos(a * c.PI) / 2 + .5
        }, $EaseLinear: function (a) {
            return a
        }, $EaseInQuad: function (a) {
            return a * a
        }, $EaseOutQuad: function (a) {
            return -a * (a - 2)
        }, $EaseInOutQuad: function (a) {
            return (a *= 2) < 1 ? 1 / 2 * a * a : -1 / 2 * (--a * (a - 2) - 1)
        }, $EaseInCubic: function (a) {
            return a * a * a
        }, $EaseOutCubic: function (a) {
            return (a -= 1) * a * a + 1
        }, $EaseInOutCubic: function (a) {
            return (a *= 2) < 1 ? 1 / 2 * a * a * a : 1 / 2 * ((a -= 2) * a * a + 2)
        }, $EaseInQuart: function (a) {
            return a * a * a * a
        }, $EaseOutQuart: function (a) {
            return -((a -= 1) * a * a * a - 1)
        }, $EaseInOutQuart: function (a) {
            return (a *= 2) < 1 ? 1 / 2 * a * a * a * a : -1 / 2 * ((a -= 2) * a * a * a - 2)
        }, $EaseInQuint: function (a) {
            return a * a * a * a * a
        }, $EaseOutQuint: function (a) {
            return (a -= 1) * a * a * a * a + 1
        }, $EaseInOutQuint: function (a) {
            return (a *= 2) < 1 ? 1 / 2 * a * a * a * a * a : 1 / 2 * ((a -= 2) * a * a * a * a + 2)
        }, $EaseInSine: function (a) {
            return 1 - c.cos(c.PI / 2 * a)
        }, $EaseOutSine: function (a) {
            return c.sin(c.PI / 2 * a)
        }, $EaseInOutSine: function (a) {
            return -1 / 2 * (c.cos(c.PI * a) - 1)
        }, $EaseInExpo: function (a) {
            return a == 0 ? 0 : c.pow(2, 10 * (a - 1))
        }, $EaseOutExpo: function (a) {
            return a == 1 ? 1 : -c.pow(2, -10 * a) + 1
        }, $EaseInOutExpo: function (a) {
            return a == 0 || a == 1 ? a : (a *= 2) < 1 ? 1 / 2 * c.pow(2, 10 * (a - 1)) : 1 / 2 * (-c.pow(2, -10 * --a) + 2)
        }, $EaseInCirc: function (a) {
            return -(c.sqrt(1 - a * a) - 1)
        }, $EaseOutCirc: function (a) {
            return c.sqrt(1 - (a -= 1) * a)
        }, $EaseInOutCirc: function (a) {
            return (a *= 2) < 1 ? -1 / 2 * (c.sqrt(1 - a * a) - 1) : 1 / 2 * (c.sqrt(1 - (a -= 2) * a) + 1)
        }, $EaseInElastic: function (a) {
            if (!a || a == 1)return a;
            var b = .3, d = .075;
            return -(c.pow(2, 10 * (a -= 1)) * c.sin((a - d) * 2 * c.PI / b))
        }, $EaseOutElastic: function (a) {
            if (!a || a == 1)return a;
            var b = .3, d = .075;
            return c.pow(2, -10 * a) * c.sin((a - d) * 2 * c.PI / b) + 1
        }, $EaseInOutElastic: function (a) {
            if (!a || a == 1)return a;
            var b = .45, d = .1125;
            return (a *= 2) < 1 ? -.5 * c.pow(2, 10 * (a -= 1)) * c.sin((a - d) * 2 * c.PI / b) : c.pow(2, -10 * (a -= 1)) * c.sin((a - d) * 2 * c.PI / b) * .5 + 1
        }, $EaseInBack: function (a) {
            var b = 1.70158;
            return a * a * ((b + 1) * a - b)
        }, $EaseOutBack: function (a) {
            var b = 1.70158;
            return (a -= 1) * a * ((b + 1) * a + b) + 1
        }, $EaseInOutBack: function (a) {
            var b = 1.70158;
            return (a *= 2) < 1 ? 1 / 2 * a * a * (((b *= 1.525) + 1) * a - b) : 1 / 2 * ((a -= 2) * a * (((b *= 1.525) + 1) * a + b) + 2)
        }, $EaseInBounce: function (a) {
            return 1 - e.$EaseOutBounce(1 - a)
        }, $EaseOutBounce: function (a) {
            return a < 1 / 2.75 ? 7.5625 * a * a : a < 2 / 2.75 ? 7.5625 * (a -= 1.5 / 2.75) * a + .75 : a < 2.5 / 2.75 ? 7.5625 * (a -= 2.25 / 2.75) * a + .9375 : 7.5625 * (a -= 2.625 / 2.75) * a + .984375
        }, $EaseInOutBounce: function (a) {
            return a < 1 / 2 ? e.$EaseInBounce(a * 2) * .5 : e.$EaseOutBounce(a * 2 - 1) * .5 + .5
        }, $EaseGoBack: function (a) {
            return 1 - c.abs(2 - 1)
        }, $EaseInWave: function (a) {
            return 1 - c.cos(a * c.PI * 2)
        }, $EaseOutWave: function (a) {
            return c.sin(a * c.PI * 2)
        }, $EaseOutJump: function (a) {
            return 1 - ((a *= 2) < 1 ? (a = 1 - a) * a * a : (a -= 1) * a * a)
        }, $EaseInJump: function (a) {
            return (a *= 2) < 1 ? a * a * a : (a = 2 - a) * a * a
        }
    }, h = j.$Jease$ = {
        $Swing: e.$EaseSwing,
        $Linear: e.$EaseLinear,
        $InQuad: e.$EaseInQuad,
        $OutQuad: e.$EaseOutQuad,
        $InOutQuad: e.$EaseInOutQuad,
        $InCubic: e.$EaseInCubic,
        $OutCubic: e.$EaseOutCubic,
        $InOutCubic: e.$EaseInOutCubic,
        $InQuart: e.$EaseInQuart,
        $OutQuart: e.$EaseOutQuart,
        $InOutQuart: e.$EaseInOutQuart,
        $InQuint: e.$EaseInQuint,
        $OutQuint: e.$EaseOutQuint,
        $InOutQuint: e.$EaseInOutQuint,
        $InSine: e.$EaseInSine,
        $OutSine: e.$EaseOutSine,
        $InOutSine: e.$EaseInOutSine,
        $InExpo: e.$EaseInExpo,
        $OutExpo: e.$EaseOutExpo,
        $InOutExpo: e.$EaseInOutExpo,
        $InCirc: e.$EaseInCirc,
        $OutCirc: e.$EaseOutCirc,
        $InOutCirc: e.$EaseInOutCirc,
        $InElastic: e.$EaseInElastic,
        $OutElastic: e.$EaseOutElastic,
        $InOutElastic: e.$EaseInOutElastic,
        $InBack: e.$EaseInBack,
        $OutBack: e.$EaseOutBack,
        $InOutBack: e.$EaseInOutBack,
        $InBounce: e.$EaseInBounce,
        $OutBounce: e.$EaseOutBounce,
        $InOutBounce: e.$EaseInOutBounce,
        $GoBack: e.$EaseGoBack,
        $InWave: e.$EaseInWave,
        $OutWave: e.$EaseOutWave,
        $OutJump: e.$EaseOutJump,
        $InJump: e.$EaseInJump
    };
    var b = new function () {
        var h = this, Ab = /\S+/g, K = 1, ib = 2, mb = 3, lb = 4, qb = 5, L, s = 0, k = 0, t = 0, z = 0,
            A = 0, D = navigator, vb = D.appName, o = D.userAgent, q = parseFloat;

        function Ib() {
            if (!L) {
                L = {Qf: "ontouchstart" in j || "createTouch" in f};
                var a;
                if (D.pointerEnabled || (a = D.msPointerEnabled))L.Nd = a ? "msTouchAction" : "touchAction"
            }
            return L
        }

        function v(h) {
            if (!s) {
                s = -1;
                if (vb == "Microsoft Internet Explorer" && !!j.attachEvent && !!j.ActiveXObject) {
                    var e = o.indexOf("MSIE");
                    s = K;
                    t = q(o.substring(e + 5, o.indexOf(";", e)));
                    /*@cc_on z=@_jscript_version@*/
                    ;
                    k = f.documentMode || t
                } else if (vb == "Netscape" && !!j.addEventListener) {
                    var d = o.indexOf("Firefox"), b = o.indexOf("Safari"), g = o.indexOf("Chrome"),
                        c = o.indexOf("AppleWebKit");
                    if (d >= 0) {
                        s = ib;
                        k = q(o.substring(d + 8))
                    } else if (b >= 0) {
                        var i = o.substring(0, b).lastIndexOf("/");
                        s = g >= 0 ? lb : mb;
                        k = q(o.substring(i + 1, b))
                    } else {
                        var a = /Trident\/.*rv:([0-9]{1,}[\.0-9]{0,})/i.exec(o);
                        if (a) {
                            s = K;
                            k = t = q(a[1])
                        }
                    }
                    if (c >= 0)A = q(o.substring(c + 12))
                } else {
                    var a = /(opera)(?:.*version|)[ \/]([\w.]+)/i.exec(o);
                    if (a) {
                        s = qb;
                        k = q(a[2])
                    }
                }
            }
            return h == s
        }

        function r() {
            return v(K)
        }

        function S() {
            return r() && (k < 6 || f.compatMode == "BackCompat")
        }

        function kb() {
            return v(mb)
        }

        function pb() {
            return v(qb)
        }

        function fb() {
            return kb() && A > 534 && A < 535
        }

        function H() {
            v();
            return A > 537 || k > 42 || s == K && k >= 11
        }

        function Q() {
            return r() && k < 9
        }

        function gb(a) {
            var b, c;
            return function (f) {
                if (!b) {
                    b = d;
                    var e = a.substr(0, 1).toUpperCase() + a.substr(1);
                    n([a].concat(["WebKit", "ms", "Moz", "O", "webkit"]), function (h, d) {
                        var b = a;
                        if (d)b = h + e;
                        if (f.style[b] != g)return c = b
                    })
                }
                return c
            }
        }

        function eb(b) {
            var a;
            return function (c) {
                a = a || gb(b)(c) || b;
                return a
            }
        }

        var M = eb("transform");

        function ub(a) {
            return {}.toString.call(a)
        }

        var rb = {};
        n(["Boolean", "Number", "String", "Function", "Array", "Date", "RegExp", "Object"], function (a) {
            rb["[object " + a + "]"] = a.toLowerCase()
        });
        function n(b, d) {
            var a, c;
            if (ub(b) == "[object Array]") {
                for (a = 0; a < b.length; a++)if (c = d(b[a], a, b))return c
            } else for (a in b)if (c = d(b[a], a, b))return c
        }

        function F(a) {
            return a == i ? String(a) : rb[ub(a)] || "object"
        }

        function sb(a) {
            for (var b in a)return d
        }

        function B(a) {
            try {
                return F(a) == "object" && !a.nodeType && a != a.window && (!a.constructor || {}.hasOwnProperty.call(a.constructor.prototype, "isPrototypeOf"))
            } catch (b) {
            }
        }

        function p(a, b) {
            return {x: a, y: b}
        }

        function yb(b, a) {
            setTimeout(b, a || 0)
        }

        function C(b, d, c) {
            var a = !b || b == "inherit" ? "" : b;
            n(d, function (c) {
                var b = c.exec(a);
                if (b) {
                    var d = a.substr(0, b.index), e = a.substr(b.index + b[0].length + 1, a.length - 1);
                    a = d + e
                }
            });
            a = c + (!a.indexOf(" ") ? "" : " ") + a;
            return a
        }

        function T(b, a) {
            if (k < 9)b.style.filter = a
        }

        h.Mf = Ib;
        h.Od = r;
        h.Lf = kb;
        h.Md = pb;
        h.Nf = H;
        h.wb = Q;
        gb("transform");
        h.Bd = function () {
            return k
        };
        h.Of = function () {
            v();
            return A
        };
        h.$Delay = yb;
        function ab(a) {
            a.constructor === ab.caller && a.zd && a.zd.apply(a, ab.caller.arguments)
        }

        h.zd = ab;
        h.lb = function (a) {
            if (h.dg(a))a = f.getElementById(a);
            return a
        };
        function u(a) {
            return a || j.event
        }

        h.Ed = u;
        h.tc = function (b) {
            b = u(b);
            var a = b.target || b.srcElement || f;
            if (a.nodeType == 3)a = h.Cd(a);
            return a
        };
        h.Dd = function (a) {
            a = u(a);
            return {x: a.pageX || a.clientX || 0, y: a.pageY || a.clientY || 0}
        };
        function G(c, d, a) {
            if (a !== g)c.style[d] = a == g ? "" : a; else {
                var b = c.currentStyle || c.style;
                a = b[d];
                if (a == "" && j.getComputedStyle) {
                    b = c.ownerDocument.defaultView.getComputedStyle(c, i);
                    b && (a = b.getPropertyValue(d) || b[d])
                }
                return a
            }
        }

        function cb(b, c, a, d) {
            if (a !== g) {
                if (a == i)a = ""; else d && (a += "px");
                G(b, c, a)
            } else return q(G(b, c))
        }

        function m(c, a) {
            var d = a ? cb : G, b;
            if (a & 4)b = eb(c);
            return function (e, f) {
                return d(e, b ? b(e) : c, f, a & 2)
            }
        }

        function Db(b) {
            if (r() && t < 9) {
                var a = /opacity=([^)]*)/.exec(b.style.filter || "");
                return a ? q(a[1]) / 100 : 1
            } else return q(b.style.opacity || "1")
        }

        function Fb(b, a, f) {
            if (r() && t < 9) {
                var h = b.style.filter || "", i = new RegExp(/[\s]*alpha\([^\)]*\)/g),
                    e = c.round(100 * a), d = "";
                if (e < 100 || f)d = "alpha(opacity=" + e + ") ";
                var g = C(h, [i], d);
                T(b, g)
            } else b.style.opacity = a == 1 ? "" : c.round(a * 100) / 100
        }

        var N = {
            $Rotate: ["rotate"],
            $RotateX: ["rotateX"],
            $RotateY: ["rotateY"],
            $SkewX: ["skewX"],
            $SkewY: ["skewY"]
        };
        if (!H())N = E(N, {$ScaleX: ["scaleX", 2], $ScaleY: ["scaleY", 2], $TranslateZ: ["translateZ", 1]});
        function O(d, a) {
            var c = "";
            if (a) {
                if (r() && k && k < 10) {
                    delete a.$RotateX;
                    delete a.$RotateY;
                    delete a.$TranslateZ
                }
                b.a(a, function (d, b) {
                    var a = N[b];
                    if (a) {
                        var e = a[1] || 0;
                        if (P[b] != d)c += " " + a[0] + "(" + d + (["deg", "px", ""])[e] + ")"
                    }
                });
                if (H()) {
                    if (a.$TranslateX || a.$TranslateY || a.$TranslateZ)c += " translate3d(" +
                        (a.$TranslateX || 0) + "px," + (a.$TranslateY || 0) + "px," +
                        (a.$TranslateZ || 0) + "px)";
                    if (a.$ScaleX == g)a.$ScaleX = 1;
                    if (a.$ScaleY == g)a.$ScaleY = 1;
                    if (a.$ScaleX != 1 || a.$ScaleY != 1)c += " scale3d(" + a.$ScaleX + ", " +
                        a.$ScaleY + ", 1)"
                }
            }
            d.style[M(d)] = c
        }

        h.Wd = m("transformOrigin", 4);
        h.Xf = m("backfaceVisibility", 4);
        h.Wf = m("transformStyle", 4);
        h.Yf = m("perspective", 6);
        h.ag = m("perspectiveOrigin", 4);
        h.Zf = function (a, b) {
            if (r() && t < 9 || t < 10 && S())a.style.zoom = b == 1 ? "" : b; else {
                var c = M(a), f = "scale(" + b + ")", e = a.style[c], g = new RegExp(/[\s]*scale\(.*?\)/g),
                    d = C(e, [g], f);
                a.style[c] = d
            }
        };
        h.hc = function (b, a) {
            return function (c) {
                c = u(c);
                var e = c.type, d = c.relatedTarget || (e == "mouseout" ? c.toElement : c.fromElement);
                (!d || d !== a && !h.vf(a, d)) && b(c)
            }
        };
        h.c = function (a, c, d, b) {
            a = h.lb(a);
            if (a.addEventListener) {
                c == "mousewheel" && a.addEventListener("DOMMouseScroll", d, b);
                a.addEventListener(c, d, b)
            } else if (a.attachEvent) {
                a.attachEvent("on" + c, d);
                b && a.setCapture && a.setCapture()
            }
        };
        h.U = function (a, c, d, b) {
            a = h.lb(a);
            if (a.removeEventListener) {
                c == "mousewheel" && a.removeEventListener("DOMMouseScroll", d, b);
                a.removeEventListener(c, d, b)
            } else if (a.detachEvent) {
                a.detachEvent("on" + c, d);
                b && a.releaseCapture && a.releaseCapture()
            }
        };
        h.fc = function (a) {
            a = u(a);
            a.preventDefault && a.preventDefault();
            a.cancel = d;
            a.returnValue = l
        };
        h.uf = function (a) {
            a = u(a);
            a.stopPropagation && a.stopPropagation();
            a.cancelBubble = d
        };
        h.I = function (d, c) {
            var a = [].slice.call(arguments, 2), b = function () {
                var b = a.concat([].slice.call(arguments, 0));
                return c.apply(d, b)
            };
            return b
        };
        h.pf = function (a, b) {
            if (b == g)return a.textContent || a.innerText;
            var c = f.createTextNode(b);
            h.Bc(a);
            a.appendChild(c)
        };
        h.yb = function (d, c) {
            for (var b = [], a = d.firstChild; a; a = a.nextSibling)(c || a.nodeType == 1) && b.push(a);
            return b
        };
        function tb(a, c, e, b) {
            b = b || "u";
            for (a = a ? a.firstChild : i; a; a = a.nextSibling)if (a.nodeType == 1) {
                if (X(a, b) == c)return a;
                if (!e) {
                    var d = tb(a, c, e, b);
                    if (d)return d
                }
            }
        }

        h.A = tb;
        function V(a, d, f, b) {
            b = b || "u";
            var c = [];
            for (a = a ? a.firstChild : i; a; a = a.nextSibling)if (a.nodeType == 1) {
                X(a, b) == d && c.push(a);
                if (!f) {
                    var e = V(a, d, f, b);
                    if (e.length)c = c.concat(e)
                }
            }
            return c
        }

        function nb(a, c, d) {
            for (a = a ? a.firstChild : i; a; a = a.nextSibling)if (a.nodeType == 1) {
                if (a.tagName == c)return a;
                if (!d) {
                    var b = nb(a, c, d);
                    if (b)return b
                }
            }
        }

        h.If = nb;
        function hb(a, c, e) {
            var b = [];
            for (a = a ? a.firstChild : i; a; a = a.nextSibling)if (a.nodeType == 1) {
                (!c || a.tagName == c) && b.push(a);
                if (!e) {
                    var d = hb(a, c, e);
                    if (d.length)b = b.concat(d)
                }
            }
            return b
        }

        h.Kf = hb;
        h.Jf = function (b, a) {
            return b.getElementsByTagName(a)
        };
        function E() {
            var e = arguments, d, c, b, a, h = 1 & e[0], f = 1 + h;
            d = e[f - 1] || {};
            for (; f < e.length; f++)if (c = e[f])for (b in c) {
                a = c[b];
                if (a !== g) {
                    a = c[b];
                    var i = d[b];
                    d[b] = h && (B(i) || B(a)) ? E(h, {}, i, a) : a
                }
            }
            return d
        }

        h.o = E;
        function bb(f, g) {
            var d = {}, c, a, b;
            for (c in f) {
                a = f[c];
                b = g[c];
                if (a !== b) {
                    var e;
                    if (B(a) && B(b)) {
                        a = bb(a, b);
                        e = !sb(a)
                    }
                    !e && (d[c] = a)
                }
            }
            return d
        }

        h.Sc = function (a) {
            return F(a) == "function"
        };
        h.dg = function (a) {
            return F(a) == "string"
        };
        h.ac = function (a) {
            return !isNaN(q(a)) && isFinite(a)
        };
        h.a = n;
        h.Hd = B;
        function U(a) {
            return f.createElement(a)
        }

        h.pb = function () {
            return U("DIV")
        };
        h.Ef = function () {
            return U("SPAN")
        };
        h.sd = function () {
        };
        function Y(b, c, a) {
            if (a == g)return b.getAttribute(c);
            b.setAttribute(c, a)
        }

        function X(a, b) {
            return Y(a, b) || Y(a, "data-" + b)
        }

        h.u = Y;
        h.j = X;
        function x(b, a) {
            if (a == g)return b.className;
            b.className = a
        }

        h.qd = x;
        function xb(b) {
            var a = {};
            n(b, function (b) {
                if (b != g)a[b] = b
            });
            return a
        }

        function zb(b, a) {
            return b.match(a || Ab)
        }

        function R(b, a) {
            return xb(zb(b || "", a))
        }

        h.Og = zb;
        function db(b, c) {
            var a = "";
            n(c, function (c) {
                a && (a += b);
                a += c
            });
            return a
        }

        function J(a, c, b) {
            x(a, db(" ", E(bb(R(x(a)), R(c)), R(b))))
        }

        h.Cd = function (a) {
            return a.parentNode
        };
        h.S = function (a) {
            h.W(a, "none")
        };
        h.z = function (a, b) {
            h.W(a, b ? "none" : "")
        };
        h.Gg = function (b, a) {
            b.removeAttribute(a)
        };
        h.Jg = function () {
            return r() && k < 10
        };
        h.Vg = function (d, a) {
            if (a)d.style.clip = "rect(" + c.round(a.$Top || a.D || 0) + "px " + c.round(a.$Right) + "px "
                + c.round(a.$Bottom) + "px " + c.round(a.$Left || a.C || 0) + "px)"; else if (a !== g) {
                var h = d.style.cssText, f = [new RegExp(/[\s]*clip: rect\(.*?\)[;]?/i), new RegExp
                    (/[\s]*cliptop: .*?[;]?/i), new RegExp(/[\s]*clipright: .*?[;]?/i), new RegExp
                    (/[\s]*clipbottom: .*?[;]?/i), new RegExp(/[\s]*clipleft: .*?[;]?/i)],
                    e = C(h, f, "");
                b.cc(d, e)
            }
        };
        h.O = function () {
            return +new Date
        };
        h.H = function (b, a) {
            b.appendChild(a)
        };
        h.Yb = function (b, a, c) {
            (c || a.parentNode).insertBefore(b, a)
        };
        h.Jb = function (b, a) {
            a = a || b.parentNode;
            a && a.removeChild(b)
        };
        h.jg = function (a, b) {
            n(a, function (a) {
                h.Jb(a, b)
            })
        };
        h.Bc = function (a) {
            h.jg(h.yb(a, d), a)
        };
        h.lg = function (a, b) {
            var c = h.Cd(a);
            b & 1 && h.v(a, (h.l(c) - h.l(a)) / 2);
            b & 2 && h.B(a, (h.m(c) - h.m(a)) / 2)
        };
        h.Zb = function (b, a) {
            return parseInt(b, a || 10)
        };
        h.vg = q;
        h.vf = function (b, a) {
            var c = f.body;
            while (a && b !== a && c !== a)try {
                a = a.parentNode
            } catch (d) {
                return l
            }
            return b === a
        };
        function Z(d, c, b) {
            var a = d.cloneNode(!c);
            !b && h.Gg(a, "id");
            return a
        }

        h.Y = Z;
        h.Lb = function (e, f) {
            var a = new Image;

            function b(e, d) {
                h.U(a, "load", b);
                h.U(a, "abort", c);
                h.U(a, "error", c);
                f && f(a, d)
            }

            function c(a) {
                b(a, d)
            }

            if (pb() && k < 11.6 || !e)b(!e); else {
                h.c(a, "load", b);
                h.c(a, "abort", c);
                h.c(a, "error", c);
                a.src = e
            }
        };
        h.wg = function (d, a, e) {
            var c = d.length + 1;

            function b(b) {
                c--;
                if (a && b && b.src == a.src)a = b;
                !c && e && e(a)
            }

            n(d, function (a) {
                h.Lb(a.src, b)
            });
            b()
        };
        h.md = function (a, g, i, h) {
            if (h)a = Z(a);
            var c = V(a, g);
            if (!c.length)c = b.Jf(a, g);
            for (var f = c.length - 1; f > -1; f--) {
                var d = c[f], e = Z(i);
                x(e, x(d));
                b.cc(e, d.style.cssText);
                b.Yb(e, d);
                b.Jb(d)
            }
            return a
        };
        function Gb(a) {
            var l = this, p = "", r = ["av", "pv", "ds", "dn"], e = [], q, k = 0, i = 0, d = 0;

            function j() {
                J(a, q, e[d || k || i & 2 || i]);
                b.Z(a, "pointer-events", d ? "none" : "")
            }

            function c() {
                k = 0;
                j();
                h.U(f, "mouseup", c);
                h.U(f, "touchend", c);
                h.U(f, "touchcancel", c)
            }

            function o(a) {
                if (d)h.fc(a); else {
                    k = 4;
                    j();
                    h.c(f, "mouseup", c);
                    h.c(f, "touchend", c);
                    h.c(f, "touchcancel", c)
                }
            }

            l.nd = function (a) {
                if (a === g)return i;
                i = a & 2 || a & 1;
                j()
            };
            l.$Enable = function (a) {
                if (a === g)return !d;
                d = a ? 0 : 3;
                j()
            };
            l.$Elmt = a = h.lb(a);
            var m = b.Og(x(a));
            if (m)p = m.shift();
            n(r, function (a) {
                e.push(p + a)
            });
            q = db(" ", e);
            e.unshift("");
            h.c(a, "mousedown", o);
            h.c(a, "touchstart", o)
        }

        h.Xb = function (a) {
            return new Gb(a)
        };
        h.Z = G;
        h.tb = m("overflow");
        h.B = m("top", 2);
        h.v = m("left", 2);
        h.l = m("width", 2);
        h.m = m("height", 2);
        h.Jd = m("marginLeft", 2);
        h.Id = m("marginTop", 2);
        h.s = m("position");
        h.W = m("display");
        h.G = m("zIndex", 1);
        h.Bb = function (b, a, c) {
            if (a != g)Fb(b, a, c); else return Db(b)
        };
        h.cc = function (a, b) {
            if (b != g)a.style.cssText = b; else return a.style.cssText
        };
        var W = {$Opacity: h.Bb, $Top: h.B, $Left: h.v, Q: h.l, P: h.m, Cb: h.s, Rh: h.W, $ZIndex: h.G};

        function w(f, l) {
            var e = Q(), b = H(), d = fb(), j = M(f);

            function k(b, d, a) {
                var e = b.rb(p(-d / 2, -a / 2)), f = b.rb(p(d / 2, -a / 2)), g = b.rb(p(d / 2, a / 2)),
                    h = b.rb(p(-d / 2, a / 2));
                b.rb(p(300, 300));
                return p(c.min(e.x, f.x, g.x, h.x) + d / 2, c.min(e.y, f.y, g.y, h.y) + a / 2)
            }

            function a(d, a) {
                a = a || {};
                var n = a.$TranslateZ || 0, p = (a.$RotateX || 0) % 360, q = (a.$RotateY || 0) % 360,
                    u = (a.$Rotate || 0) % 360, l = a.$ScaleX, m = a.$ScaleY, f = a.Qh;
                if (l == g)l = 1;
                if (m == g)m = 1;
                if (f == g)f = 1;
                if (e) {
                    n = 0;
                    p = 0;
                    q = 0;
                    f = 0
                }
                var c = new Cb(a.$TranslateX, a.$TranslateY, n);
                c.$RotateX(p);
                c.$RotateY(q);
                c.we(u);
                c.ze(a.$SkewX, a.$SkewY);
                c.$Scale(l, m, f);
                if (b) {
                    c.$Move(a.C, a.D);
                    d.style[j] = c.be()
                } else if (!z || z < 9) {
                    var o = "", i = {x: 0, y: 0};
                    if (a.$OriginalWidth)i = k(c, a.$OriginalWidth, a.$OriginalHeight);
                    h.Id(d, i.y);
                    h.Jd(d, i.x);
                    o = c.ae();
                    var s = d.style.filter,
                        t = new RegExp(/[\s]*progid:DXImageTransform\.Microsoft\.Matrix\([^\)]*\)/g),
                        r = C(s, [t], o);
                    T(d, r)
                }
            }

            w = function (e, c) {
                c = c || {};
                var j = c.C, k = c.D, f;
                n(W, function (a, b) {
                    f = c[b];
                    f !== g && a(e, f)
                });
                h.Vg(e, c.$Clip);
                if (!b) {
                    j != g && h.v(e, (c.gd || 0) + j);
                    k != g && h.B(e, (c.id || 0) + k)
                }
                if (c.je)if (d)yb(h.I(i, O, e, c)); else a(e, c)
            };
            h.zb = O;
            if (d)h.zb = w;
            if (e)h.zb = a; else if (!b)a = O;
            h.L = w;
            w(f, l)
        }

        h.zb = w;
        h.L = w;
        function Cb(j, k, o) {
            var d = this, b = [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, j || 0, k || 0, o || 0, 1], h = c.sin,
                g = c.cos, l = c.tan;

            function f(a) {
                return a * c.PI / 180
            }

            function n(a, b) {
                return {x: a, y: b}
            }

            function m(b, c, f, g, i, l, n, o, q, t, u, w, y, A, C, F, a, d, e, h, j, k, m, p, r, s, v, x, z, B, D, E) {
                return [b * a + c * j + f * r + g * z, b * d + c * k + f * s + g * B, b * e + c * m + f * v + g * D, b * h + c * p + f * x + g * E, i * a + l * j + n * r + o * z, i * d + l * k + n * s + o * B, i * e + l * m + n * v + o * D, i * h + l * p + n * x + o * E, q * a + t * j + u * r + w * z, q * d + t * k + u * s + w * B, q * e + t * m + u * v + w * D, q * h + t * p + u * x + w * E, y * a + A * j + C * r + F * z, y * d + A * k + C * s + F * B, y * e + A * m + C * v + F * D, y * h + A * p + C * x + F * E]
            }

            function e(c, a) {
                return m.apply(i, (a || b).concat(c))
            }

            d.$Scale = function (a, c, d) {
                if (a != 1 || c != 1 || d != 1)b = e([a, 0, 0, 0, 0, c, 0, 0, 0, 0, d, 0, 0, 0, 0, 1])
            };
            d.$Move = function (a, c, d) {
                b[12] += a || 0;
                b[13] += c || 0;
                b[14] += d || 0
            };
            d.$RotateX = function (c) {
                if (c) {
                    a = f(c);
                    var d = g(a), i = h(a);
                    b = e([1, 0, 0, 0, 0, d, i, 0, 0, -i, d, 0, 0, 0, 0, 1])
                }
            };
            d.$RotateY = function (c) {
                if (c) {
                    a = f(c);
                    var d = g(a), i = h(a);
                    b = e([d, 0, -i, 0, 0, 1, 0, 0, i, 0, d, 0, 0, 0, 0, 1])
                }
            };
            d.we = function (c) {
                if (c) {
                    a = f(c);
                    var d = g(a), i = h(a);
                    b = e([d, i, 0, 0, -i, d, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1])
                }
            };
            d.ze = function (a, c) {
                if (a || c) {
                    j = f(a);
                    k = f(c);
                    b = e([1, l(k), 0, 0, l(j), 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1])
                }
            };
            d.rb = function (c) {
                var a = e(b, [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, c.x, c.y, 0, 1]);
                return n(a[12], a[13])
            };
            d.be = function () {
                return "matrix3d(" + b.join(",") + ")"
            };
            d.ae = function () {
                return "progid:DXImageTransform.Microsoft.Matrix(M11=" + b[0] + ", M12=" + b[4] + ", M21=" + b[1] + ", M22=" + b[5] + ", SizingMethod='auto expand')"
            }
        }

        new (function () {
            var a = this;

            function b(d, g) {
                for (var j = d[0].length, i = d.length, h = g[0].length, f = [], c = 0; c < i; c++)for
                (var k = f[c] = [], b = 0; b < h; b++) {
                    for (var e = 0, a = 0; a < j; a++)e += d[c][a] * g[a][b];
                    k[b] = e
                }
                return f
            }

            a.$ScaleX = function (b, c) {
                return a.hd(b, c, 0)
            };
            a.$ScaleY = function (b, c) {
                return a.hd(b, 0, c)
            };
            a.hd = function (a, c, d) {
                return b(a, [[c, 0], [0, d]])
            };
            a.rb = function (d, c) {
                var a = b(d, [[c.x], [c.y]]);
                return p(a[0][0], a[1][0])
            }
        });
        var P = {
            gd: 0,
            id: 0,
            C: 0,
            D: 0,
            $Zoom: 1,
            $ScaleX: 1,
            $ScaleY: 1,
            $Rotate: 0,
            $RotateX: 0,
            $RotateY: 0,
            $TranslateX: 0,
            $TranslateY: 0,
            $TranslateZ: 0,
            $SkewX: 0,
            $SkewY: 0
        };
        h.yc = function (a) {
            var c = a || {};
            if (a)if (b.Sc(a))c = {wc: c}; else if (b.Sc(a.$Clip))c.$Clip = {wc: a.$Clip};
            return c
        };
        function wb(c, a) {
            var b = {};
            n(c, function (c, d) {
                var e = c;
                if (a[d] != g)if (h.ac(c))e = c + a[d]; else e = wb(c, a[d]);
                b[d] = e
            });
            return b
        }

        h.Zd = wb;
        h.td = function (l, m, x, q, z, A, n) {
            var a = m;
            if (l) {
                a = {};
                for (var h in m) {
                    var B = A[h] || 1, w = z[h] || [0, 1], f = (x - w[0]) / w[1];
                    f = c.min(c.max(f, 0), 1);
                    f = f * B;
                    var u = c.floor(f);
                    if (f != u)f -= u;
                    var j = q.wc || e.$EaseSwing, k, C = l[h], p = m[h];
                    if (b.ac(p)) {
                        j = q[h] || j;
                        var y = j(f);
                        k = C + p * y
                    } else {
                        k = b.o({gc: {}}, l[h]);
                        var v = q[h] || {};
                        b.a(p.gc || p, function (d, a) {
                            j = v[a] || v.wc || j;
                            var c = j(f), b = d * c;
                            k.gc[a] = b;
                            k[a] += b
                        })
                    }
                    a[h] = k
                }
                var t = b.a(m, function (b, a) {
                    return P[a] != g
                });
                t && b.a(P, function (c, b) {
                    if (a[b] == g && l[b] !== g)a[b] = l[b]
                });
                if (t) {
                    if (a.$Zoom)a.$ScaleX = a.$ScaleY = a.$Zoom;
                    a.$OriginalWidth = n.$OriginalWidth;
                    a.$OriginalHeight = n.$OriginalHeight;
                    a.je = d
                }
            }
            if (m.$Clip && n.$Move) {
                var o = a.$Clip.gc, s = (o.$Top || 0) + (o.$Bottom || 0), r = (o.$Left || 0) +
                    (o.$Right || 0);
                a.$Left = (a.$Left || 0) + r;
                a.$Top = (a.$Top || 0) + s;
                a.$Clip.$Left -= r;
                a.$Clip.$Right -= r;
                a.$Clip.$Top -= s;
                a.$Clip.$Bottom -= s
            }
            if (a.$Clip && b.Jg() && !a.$Clip.$Top && !a.$Clip.$Left && !a.$Clip.D && !a.$Clip.C && a.$Clip.$Right == n.$OriginalWidth &&
                a.$Clip.$Bottom == n.$OriginalHeight)a.$Clip = i;
            return a
        }
    };

    function n() {
        var a = this, d = [];

        function h(a, b) {
            d.push({uc: a, vc: b})
        }

        function g(a, c) {
            b.a(d, function (b, e) {
                b.uc == a && b.vc === c && d.splice(e, 1)
            })
        }

        a.$On = a.addEventListener = h;
        a.$Off = a.removeEventListener = g;
        a.k = function (a) {
            var c = [].slice.call(arguments, 1);
            b.a(d, function (b) {
                b.uc == a && b.vc.apply(j, c)
            })
        }
    }

    var m = function (z, C, h, M, P, J) {
        z = z || 0;
        var a = this, q, n, o, v, A = 0, H, I, G, B, y = 0, g = 0, m = 0, D, k, f, e, p, L, w = [], x;

        function Q(a) {
            f += a;
            e += a;
            k += a;
            g += a;
            m += a;
            y += a
        }

        function u(o) {
            var i = o;
            if (p && (i >= e || i <= f && !L))i = ((i - f) % p + p) % p + f;
            if (!D || v || g != i) {
                var j = c.min(i, e);
                j = c.max(j, f);
                if (!D || v || j != m) {
                    if (J) {
                        var l = (j - k) / (C || 1);
                        if (h.$Reverse)l = 1 - l;
                        var n = b.td(P, J, l, H, G, I, h);
                        if (x)b.a(n, function (b, a) {
                            x[a] && x[a](M, b)
                        }); else b.L(M, n)
                    }
                    a.Ec(m - k, j - k);
                    m = j;
                    b.a(w, function (b, c) {
                        var a = o < g ? w[w.length - c - 1] : b;
                        a.E(m - y)
                    });
                    var r = g, q = m;
                    g = i;
                    D = d;
                    a.dc(r, q)
                }
            }
        }

        function E(a, b, d) {
            b && a.$Shift(e);
            if (!d) {
                f = c.min(f, a.Ac() + y);
                e = c.max(e, a.Db() + y)
            }
            w.push(a)
        }

        var r = j.requestAnimationFrame || j.webkitRequestAnimationFrame || j.mozRequestAnimationFrame ||
            j.msRequestAnimationFrame;
        if (b.Lf() && b.Bd() < 7)r = i;
        r = r || function (a) {
                b.$Delay(a, h.$Interval)
            };
        function K() {
            if (q) {
                var d = b.O(), e = c.min(d - A, h.Mc), a = g + e * o;
                A = d;
                if (a * o >= n * o)a = n;
                u(a);
                if (!v && a * o >= n * o)N(B); else r(K)
            }
        }

        function t(h, i, j) {
            if (!q) {
                q = d;
                v = j;
                B = i;
                h = c.max(h, f);
                h = c.min(h, e);
                n = h;
                o = n < g ? -1 : 1;
                a.Oc();
                A = b.O();
                r(K)
            }
        }

        function N(b) {
            if (q) {
                v = q = B = l;
                a.bd();
                b && b()
            }
        }

        a.$Play = function (a, b, c) {
            t(a ? g + a : e, b, c)
        };
        a.dd = t;
        a.mb = N;
        a.Qe = function (a) {
            t(a)
        };
        a.db = function () {
            return g
        };
        a.Zc = function () {
            return n
        };
        a.Eb = function () {
            return m
        };
        a.E = u;
        a.$Move = function (a) {
            u(g + a)
        };
        a.$IsPlaying = function () {
            return q
        };
        a.ef = function (a) {
            p = a
        };
        a.$Shift = Q;
        a.eb = function (a, b) {
            E(a, 0, b)
        };
        a.mc = function (a) {
            E(a, 1)
        };
        a.de = function (a) {
            e += a
        };
        a.Ac = function () {
            return f
        };
        a.Db = function () {
            return e
        };
        a.dc = a.Oc = a.bd = a.Ec = b.sd;
        a.nc = b.O();
        h = b.o({$Interval: 16, Mc: 50}, h);
        p = h.kc;
        L = h.Yd;
        x = h.ee;
        f = k = z;
        e = z + C;
        I = h.$Round || {};
        G = h.$During || {};
        H = b.yc(h.$Easing)
    };
    var p = j.$JssorSlideshowFormations$ = new function () {
        var h = this, b = 0, a = 1, f = 2, e = 3, s = 1, r = 2, t = 4, q = 8, w = 256, x = 512, v = 1024, u = 2048, j = u + s, i = u + r, o = x + s, m = x + r, n = w + t, k = w + q, l = v + t, p = v + q;

        function y(a) {
            return (a & r) == r
        }

        function z(a) {
            return (a & t) == t
        }

        function g(b, a, c) {
            c.push(a);
            b[a] = b[a] || [];
            b[a].push(c)
        }

        h.$FormationStraight = function (f) {
            for (var d = f.$Cols, e = f.$Rows, s = f.$Assembly, t = f.Sb, r = [], a = 0, b = 0, p = d - 1, q = e - 1, h = t - 1, c, b = 0; b < e; b++)for (a = 0; a < d; a++) {
                switch (s) {
                    case j:
                        c = h - (a * e + (q - b));
                        break;
                    case l:
                        c = h - (b * d + (p - a));
                        break;
                    case o:
                        c = h - (a * e + b);
                    case n:
                        c = h - (b * d + a);
                        break;
                    case i:
                        c = a * e + b;
                        break;
                    case k:
                        c = b * d + (p - a);
                        break;
                    case m:
                        c = a * e + (q - b);
                        break;
                    default:
                        c = b * d + a
                }
                g(r, c, [b, a])
            }
            return r
        };
        h.$FormationSwirl = function (q) {
            var x = q.$Cols, y = q.$Rows, B = q.$Assembly, w = q.Sb, A = [], z = [], u = 0, c = 0, h = 0, r = x - 1, s = y - 1, t, p, v = 0;
            switch (B) {
                case j:
                    c = r;
                    h = 0;
                    p = [f, a, e, b];
                    break;
                case l:
                    c = 0;
                    h = s;
                    p = [b, e, a, f];
                    break;
                case o:
                    c = r;
                    h = s;
                    p = [e, a, f, b];
                    break;
                case n:
                    c = r;
                    h = s;
                    p = [a, e, b, f];
                    break;
                case i:
                    c = 0;
                    h = 0;
                    p = [f, b, e, a];
                    break;
                case k:
                    c = r;
                    h = 0;
                    p = [a, f, b, e];
                    break;
                case m:
                    c = 0;
                    h = s;
                    p = [e, b, f, a];
                    break;
                default:
                    c = 0;
                    h = 0;
                    p = [b, f, a, e]
            }
            u = 0;
            while (u < w) {
                t = h + "," + c;
                if (c >= 0 && c < x && h >= 0 && h < y && !z[t]) {
                    z[t] = d;
                    g(A, u++, [h, c])
                } else switch (p[v++ % p.length]) {
                    case b:
                        c--;
                        break;
                    case f:
                        h--;
                        break;
                    case a:
                        c++;
                        break;
                    case e:
                        h++
                }
                switch (p[v % p.length]) {
                    case b:
                        c++;
                        break;
                    case f:
                        h++;
                        break;
                    case a:
                        c--;
                        break;
                    case e:
                        h--
                }
            }
            return A
        };
        h.$FormationZigZag = function (p) {
            var w = p.$Cols, x = p.$Rows, z = p.$Assembly, v = p.Sb, t = [], u = 0, c = 0, d = 0, q = w - 1, r = x - 1, y, h, s = 0;
            switch (z) {
                case j:
                    c = q;
                    d = 0;
                    h = [f, a, e, a];
                    break;
                case l:
                    c = 0;
                    d = r;
                    h = [b, e, a, e];
                    break;
                case o:
                    c = q;
                    d = r;
                    h = [e, a, f, a];
                    break;
                case n:
                    c = q;
                    d = r;
                    h = [a, e, b, e];
                    break;
                case i:
                    c = 0;
                    d = 0;
                    h = [f, b, e, b];
                    break;
                case k:
                    c = q;
                    d = 0;
                    h = [a, f, b, f];
                    break;
                case m:
                    c = 0;
                    d = r;
                    h = [e, b, f, b];
                    break;
                default:
                    c = 0;
                    d = 0;
                    h = [b, f, a, f]
            }
            u = 0;
            while (u < v) {
                y = d + "," + c;
                if (c >= 0 && c < w && d >= 0 && d < x && typeof t[y] == "undefined") {
                    g(t, u++, [d, c]);
                    switch (h[s % h.length]) {
                        case b:
                            c++;
                            break;
                        case f:
                            d++;
                            break;
                        case a:
                            c--;
                            break;
                        case e:
                            d--
                    }
                } else {
                    switch (h[s++ % h.length]) {
                        case b:
                            c--;
                            break;
                        case f:
                            d--;
                            break;
                        case a:
                            c++;
                            break;
                        case e:
                            d++
                    }
                    switch (h[s++ % h.length]) {
                        case b:
                            c++;
                            break;
                        case f:
                            d++;
                            break;
                        case a:
                            c--;
                            break;
                        case e:
                            d--
                    }
                }
            }
            return t
        };
        h.$FormationStraightStairs = function (q) {
            var u = q.$Cols, v = q.$Rows, e = q.$Assembly, t = q.Sb, r = [], s = 0, c = 0, d = 0, f = u - 1, h = v - 1, x = t - 1;
            switch (e) {
                case j:
                case m:
                case o:
                case i:
                    var a = 0, b = 0;
                    break;
                case k:
                case l:
                case n:
                case p:
                    var a = f, b = 0;
                    break;
                default:
                    e = p;
                    var a = f, b = 0
            }
            c = a;
            d = b;
            while (s < t) {
                if (z(e) || y(e))g(r, x - s++, [d, c]); else g(r, s++, [d, c]);
                switch (e) {
                    case j:
                    case m:
                        c--;
                        d++;
                        break;
                    case o:
                    case i:
                        c++;
                        d--;
                        break;
                    case k:
                    case l:
                        c--;
                        d--;
                        break;
                    case p:
                    case n:
                    default:
                        c++;
                        d++
                }
                if (c < 0 || d < 0 || c > f || d > h) {
                    switch (e) {
                        case j:
                        case m:
                            a++;
                            break;
                        case k:
                        case l:
                        case o:
                        case i:
                            b++;
                            break;
                        case p:
                        case n:
                        default:
                            a--
                    }
                    if (a < 0 || b < 0 || a > f || b > h) {
                        switch (e) {
                            case j:
                            case m:
                                a = f;
                                b++;
                                break;
                            case o:
                            case i:
                                b = h;
                                a++;
                                break;
                            case k:
                            case l:
                                b = h;
                                a--;
                                break;
                            case p:
                            case n:
                            default:
                                a = 0;
                                b++
                        }
                        if (b > h)b = h; else if (b < 0)b = 0; else if (a > f)a = f; else if (a < 0)a = 0
                    }
                    d = b;
                    c = a
                }
            }
            return r
        };
        h.$FormationSquare = function (i) {
            var a = i.$Cols || 1, b = i.$Rows || 1, j = [], d, e, f, h, k;
            f = a < b ? (b - a) / 2 : 0;
            h = a > b ? (a - b) / 2 : 0;
            k = c.round(c.max(a / 2, b / 2)) + 1;
            for (d = 0; d < a; d++)for (e = 0; e < b; e++)g(j, k - c.min(d + 1 + f, e + 1 + h, a - d + f, b - e + h), [e, d]);
            return j
        };
        h.$FormationRectangle = function (f) {
            var d = f.$Cols || 1, e = f.$Rows || 1, h = [], a, b, i;
            i = c.round(c.min(d / 2, e / 2)) + 1;
            for (a = 0; a < d; a++)for (b = 0; b < e; b++)g(h, i - c.min(a + 1, b + 1, d - a, e - b), [b, a]);
            return h
        };
        h.$FormationRandom = function (d) {
            for (var e = [], a, b = 0; b < d.$Rows; b++)for (a = 0; a < d.$Cols; a++)g(e, c.ceil(1e5 * c.random()) % 13, [b, a]);
            return e
        };
        h.$FormationCircle = function (d) {
            for (var e = d.$Cols || 1, f = d.$Rows || 1, h = [], a, i = e / 2 - .5, j = f / 2 - .5, b = 0; b < e; b++)for (a = 0; a < f; a++)g(h, c.round(c.sqrt(c.pow(b - i, 2) + c.pow(a - j, 2))), [a, b]);
            return h
        };
        h.$FormationCross = function (d) {
            for (var e = d.$Cols || 1, f = d.$Rows || 1, h = [], a, i = e / 2 - .5, j = f / 2 - .5, b = 0; b < e; b++)for (a = 0; a < f; a++)g(h, c.round(c.min(c.abs(b - i), c.abs(a - j))), [a, b]);
            return h
        };
        h.$FormationRectangleCross = function (f) {
            for (var h = f.$Cols || 1, i = f.$Rows || 1, j = [], a, d = h / 2 - .5, e = i / 2 - .5, k = c.max(d, e) + 1, b = 0; b < h; b++)for (a = 0; a < i; a++)g(j, c.round(k - c.max(d - c.abs(b - d), e - c.abs(a - e))) - 1, [a, b]);
            return j
        }
    };
    j.$JssorSlideshowRunner$ = function (k, s, q, u, z) {
        var f = this, v, g, a, y = 0, x = u.$TransitionsOrder, r, h = 8;

        function t(a) {
            if (a.$Top)a.D = a.$Top;
            if (a.$Left)a.C = a.$Left;
            b.a(a, function (a) {
                b.Hd(a) && t(a)
            })
        }

        function j(g, f) {
            var a = {
                $Interval: f,
                $Duration: 1,
                $Delay: 0,
                $Cols: 1,
                $Rows: 1,
                $Opacity: 0,
                $Zoom: 0,
                $Clip: 0,
                $Move: l,
                $SlideOut: l,
                $Reverse: l,
                $Formation: p.$FormationRandom,
                $Assembly: 1032,
                $ChessMode: {$Column: 0, $Row: 0},
                $Easing: e.$EaseSwing,
                $Round: {},
                Nb: [],
                $During: {}
            };
            b.o(a, g);
            t(a);
            a.Sb = a.$Cols * a.$Rows;
            a.$Easing = b.yc(a.$Easing);
            a.ne = c.ceil(a.$Duration / a.$Interval);
            a.re = function (c, b) {
                c /= a.$Cols;
                b /= a.$Rows;
                var f = c + "x" + b;
                if (!a.Nb[f]) {
                    a.Nb[f] = {Q: c, P: b};
                    for (var d = 0; d < a.$Cols; d++)for (var e = 0; e < a.$Rows; e++)a.Nb[f][e + "," + d] = {
                        $Top: e * b,
                        $Right: d * c + c,
                        $Bottom: e * b + b,
                        $Left: d * c
                    }
                }
                return a.Nb[f]
            };
            if (a.$Brother) {
                a.$Brother = j(a.$Brother, f);
                a.$SlideOut = d
            }
            return a
        }

        function o(B, h, a, w, o, m) {
            var z = this, u, v = {}, j = {}, n = [], f, e, s, q = a.$ChessMode.$Column || 0, r = a.$ChessMode.$Row || 0, g = a.re(o, m), p = C(a), D = p.length - 1, t = a.$Duration + a.$Delay * D, x = w + t, k = a.$SlideOut, y;
            x += 50;
            function C(a) {
                var b = a.$Formation(a);
                return a.$Reverse ? b.reverse() : b
            }

            z.Td = x;
            z.Tb = function (d) {
                d -= w;
                var e = d < t;
                if (e || y) {
                    y = e;
                    if (!k)d = t - d;
                    var f = c.ceil(d / a.$Interval);
                    b.a(j, function (a, e) {
                        var d = c.max(f, a.Me);
                        d = c.min(d, a.length - 1);
                        if (a.Tc != d) {
                            if (!a.Tc && !k)b.z(n[e]); else d == a.Je && k && b.S(n[e]);
                            a.Tc = d;
                            b.L(n[e], a[d])
                        }
                    })
                }
            };
            h = b.Y(h);
            b.zb(h, i);
            if (b.wb()) {
                var E = !h["no-image"], A = b.Kf(h);
                b.a(A, function (a) {
                    (E || a["jssor-slider"]) && b.Bb(a, b.Bb(a), d)
                })
            }
            b.a(p, function (h, i) {
                b.a(h, function (G) {
                    var K = G[0], J = G[1], t = K + "," + J, n = l, p = l, x = l;
                    if (q && J % 2) {
                        if (q & 3)n = !n;
                        if (q & 12)p = !p;
                        if (q & 16)x = !x
                    }
                    if (r && K % 2) {
                        if (r & 3)n = !n;
                        if (r & 12)p = !p;
                        if (r & 16)x = !x
                    }
                    a.$Top = a.$Top || a.$Clip & 4;
                    a.$Bottom = a.$Bottom || a.$Clip & 8;
                    a.$Left = a.$Left || a.$Clip & 1;
                    a.$Right = a.$Right || a.$Clip & 2;
                    var C = p ? a.$Bottom : a.$Top, z = p ? a.$Top : a.$Bottom, B = n ? a.$Right : a.$Left, A = n ? a.$Left : a.$Right;
                    a.$Clip = C || z || B || A;
                    s = {};
                    e = {D: 0, C: 0, $Opacity: 1, Q: o, P: m};
                    f = b.o({}, e);
                    u = b.o({}, g[t]);
                    if (a.$Opacity)e.$Opacity = 2 - a.$Opacity;
                    if (a.$ZIndex) {
                        e.$ZIndex = a.$ZIndex;
                        f.$ZIndex = 0
                    }
                    var I = a.$Cols * a.$Rows > 1 || a.$Clip;
                    if (a.$Zoom || a.$Rotate) {
                        var H = d;
                        if (b.wb())if (a.$Cols * a.$Rows > 1)H = l; else I = l;
                        if (H) {
                            e.$Zoom = a.$Zoom ? a.$Zoom - 1 : 1;
                            f.$Zoom = 1;
                            if (b.wb() || b.Md())e.$Zoom = c.min(e.$Zoom, 2);
                            var N = a.$Rotate || 0;
                            e.$Rotate = N * 360 * (x ? -1 : 1);
                            f.$Rotate = 0
                        }
                    }
                    if (I) {
                        var h = u.gc = {};
                        if (a.$Clip) {
                            var w = a.$ScaleClip || 1;
                            if (C && z) {
                                h.$Top = g.P / 2 * w;
                                h.$Bottom = -h.$Top
                            } else if (C)h.$Bottom = -g.P * w; else if (z)h.$Top = g.P * w;
                            if (B && A) {
                                h.$Left = g.Q / 2 * w;
                                h.$Right = -h.$Left
                            } else if (B)h.$Right = -g.Q * w; else if (A)h.$Left = g.Q * w
                        }
                        s.$Clip = u;
                        f.$Clip = g[t]
                    }
                    var L = n ? 1 : -1, M = p ? 1 : -1;
                    if (a.x)e.C += o * a.x * L;
                    if (a.y)e.D += m * a.y * M;
                    b.a(e, function (a, c) {
                        if (b.ac(a))if (a != f[c])s[c] = a - f[c]
                    });
                    v[t] = k ? f : e;
                    var D = a.ne, y = c.round(i * a.$Delay / a.$Interval);
                    j[t] = new Array(y);
                    j[t].Me = y;
                    j[t].Je = y + D - 1;
                    for (var F = 0; F <= D; F++) {
                        var E = b.td(f, s, F / D, a.$Easing, a.$During, a.$Round, {
                            $Move: a.$Move,
                            $OriginalWidth: o,
                            $OriginalHeight: m
                        });
                        E.$ZIndex = E.$ZIndex || 1;
                        j[t].push(E)
                    }
                })
            });
            p.reverse();
            b.a(p, function (a) {
                b.a(a, function (c) {
                    var f = c[0], e = c[1], d = f + "," + e, a = h;
                    if (e || f)a = b.Y(h);
                    b.L(a, v[d]);
                    b.tb(a, "hidden");
                    b.s(a, "absolute");
                    B.Ke(a);
                    n[d] = a;
                    b.z(a, !k)
                })
            })
        }

        function w() {
            var b = this, c = 0;
            m.call(b, 0, v);
            b.dc = function (d, b) {
                if (b - c > h) {
                    c = b;
                    a && a.Tb(b);
                    g && g.Tb(b)
                }
            };
            b.Hc = r
        }

        f.df = function () {
            var a = 0, b = u.$Transitions, d = b.length;
            if (x)a = y++ % d; else a = c.floor(c.random() * d);
            b[a] && (b[a].ib = a);
            return b[a]
        };
        f.ge = function (w, x, l, m, b) {
            r = b;
            b = j(b, h);
            var i = m.kd, e = l.kd;
            i["no-image"] = !m.Ob;
            e["no-image"] = !l.Ob;
            var n = i, p = e, u = b, d = b.$Brother || j({}, h);
            if (!b.$SlideOut) {
                n = e;
                p = i
            }
            var t = d.$Shift || 0;
            g = new o(k, p, d, c.max(t - d.$Interval, 0), s, q);
            a = new o(k, n, u, c.max(d.$Interval - t, 0), s, q);
            g.Tb(0);
            a.Tb(0);
            v = c.max(g.Td, a.Td);
            f.ib = w
        };
        f.Ib = function () {
            k.Ib();
            g = i;
            a = i
        };
        f.Ee = function () {
            var b = i;
            if (a)b = new w;
            return b
        };
        if (b.wb() || b.Md() || z && b.Of() < 537)h = 16;
        n.call(f);
        m.call(f, -1e7, 1e7)
    };
    var k = j.$JssorSlider$ = function (p, hc) {
        var h = this;

        function Fc() {
            var a = this;
            m.call(a, -1e8, 2e8);
            a.bf = function () {
                var b = a.Eb(), d = c.floor(b), f = t(d), e = b - c.floor(b);
                return {ib: f, Ye: d, Cb: e}
            };
            a.dc = function (b, a) {
                var e = c.floor(a);
                if (e != a && a > b)e++;
                Wb(e, d);
                h.k(k.$EVT_POSITION_CHANGE, t(a), t(b), a, b)
            }
        }

        function Ec() {
            var a = this;
            m.call(a, 0, 0, {kc: r});
            b.a(C, function (b) {
                D & 1 && b.ef(r);
                a.mc(b);
                b.$Shift(gb / dc)
            })
        }

        function Dc() {
            var a = this, b = Vb.$Elmt;
            m.call(a, -1, 2, {$Easing: e.$EaseLinear, ee: {Cb: bc}, kc: r}, b, {Cb: 1}, {Cb: -2});
            a.Mb = b
        }

        function rc(o, n) {
            var b = this, e, f, g, j, c;
            m.call(b, -1e8, 2e8, {Mc: 100});
            b.Oc = function () {
                O = d;
                R = i;
                h.k(k.$EVT_SWIPE_START, t(w.db()), w.db())
            };
            b.bd = function () {
                O = l;
                j = l;
                var a = w.bf();
                h.k(k.$EVT_SWIPE_END, t(w.db()), w.db());
                !a.Cb && Hc(a.Ye, s)
            };
            b.dc = function (i, h) {
                var b;
                if (j)b = c; else {
                    b = f;
                    if (g) {
                        var d = h / g;
                        b = a.$SlideEasing(d) * (f - e) + e
                    }
                }
                w.E(b)
            };
            b.Rb = function (a, d, c, h) {
                e = a;
                f = d;
                g = c;
                w.E(a);
                b.E(0);
                b.dd(c, h)
            };
            b.Te = function (a) {
                j = d;
                c = a;
                b.$Play(a, i, d)
            };
            b.Se = function (a) {
                c = a
            };
            w = new Fc;
            w.eb(o);
            w.eb(n)
        }

        function sc() {
            var c = this, a = Zb();
            b.G(a, 0);
            b.Z(a, "pointerEvents", "none");
            c.$Elmt = a;
            c.Ke = function (c) {
                b.H(a, c);
                b.z(a)
            };
            c.Ib = function () {
                b.S(a);
                b.Bc(a)
            }
        }

        function Bc(j, f) {
            var e = this, q, L, x, o, y = [], w, B, W, H, S, F, g, v, p;
            m.call(e, -u, u + 1, {});
            function E(a) {
                q && q.Qd();
                T(j, a, 0);
                F = d;
                q = new I.$Class(j, I, b.vg(b.j(j, "idle")) || qc);
                q.E(0)
            }

            function Y() {
                q.nc < I.nc && E()
            }

            function O(p, r, n) {
                if (!H) {
                    H = d;
                    if (o && n) {
                        var g = n.width, c = n.height, m = g, j = c;
                        if (g && c && a.$FillMode) {
                            if (a.$FillMode & 3 && (!(a.$FillMode & 4) || g > K || c > J)) {
                                var i = l, q = K / J * c / g;
                                if (a.$FillMode & 1)i = q > 1; else if (a.$FillMode & 2)i = q < 1;
                                m = i ? g * J / c : K;
                                j = i ? J : c * K / g
                            }
                            b.l(o, m);
                            b.m(o, j);
                            b.B(o, (J - j) / 2);
                            b.v(o, (K - m) / 2)
                        }
                        b.s(o, "absolute");
                        h.k(k.$EVT_LOAD_END, f)
                    }
                }
                b.S(r);
                p && p(e)
            }

            function X(b, c, d, g) {
                if (g == R && s == f && P)if (!Gc) {
                    var a = t(b);
                    A.ge(a, f, c, e, d);
                    c.hf();
                    U.$Shift(a - U.Ac() - 1);
                    U.E(a);
                    z.Rb(b, b, 0)
                }
            }

            function ab(b) {
                if (b == R && s == f) {
                    if (!g) {
                        var a = i;
                        if (A)if (A.ib == f)a = A.Ee(); else A.Ib();
                        Y();
                        g = new zc(j, f, a, q);
                        g.Yc(p)
                    }
                    !g.$IsPlaying() && g.Fc()
                }
            }

            function G(d, h, l) {
                if (d == f) {
                    if (d != h)C[h] && C[h].Vc(); else!l && g && g.Oe();
                    p && p.$Enable();
                    var m = R = b.O();
                    e.Lb(b.I(i, ab, m))
                } else {
                    var k = c.min(f, d), j = c.max(f, d), o = c.min(j - k, k + r - j), n = u + a.$LazyLoading - 1;
                    (!S || o <= n) && e.Lb()
                }
            }

            function bb() {
                if (s == f && g) {
                    g.mb();
                    p && p.$Quit();
                    p && p.$Disable();
                    g.od()
                }
            }

            function eb() {
                s == f && g && g.mb()
            }

            function Z(a) {
                !M && h.k(k.$EVT_CLICK, f, a)
            }

            function Q() {
                p = v.pInstance;
                g && g.Yc(p)
            }

            e.Lb = function (c, a) {
                a = a || x;
                if (y.length && !H) {
                    b.z(a);
                    if (!W) {
                        W = d;
                        h.k(k.$EVT_LOAD_START, f);
                        b.a(y, function (a) {
                            if (!b.u(a, "src")) {
                                a.src = b.j(a, "src2");
                                b.W(a, a["display-origin"])
                            }
                        })
                    }
                    b.wg(y, o, b.I(i, O, c, a))
                } else O(c, a)
            };
            e.af = function () {
                var j = f;
                if (a.$AutoPlaySteps < 0)j -= r;
                var d = j + a.$AutoPlaySteps * xc;
                if (D & 2)d = t(d);
                if (!(D & 1) && !db)d = c.max(0, c.min(d, r - u));
                if (d != f) {
                    if (A) {
                        var g = A.df(r);
                        if (g) {
                            var k = R = b.O(), h = C[t(d)];
                            return h.Lb(b.I(i, X, d, h, g, k), x)
                        }
                    }
                    ob(d)
                } else if (a.$Loop) {
                    e.Vc();
                    G(f, f)
                }
            };
            e.xc = function () {
                G(f, f, d)
            };
            e.Vc = function () {
                p && p.$Quit();
                p && p.$Disable();
                e.fd();
                g && g.De();
                g = i;
                E()
            };
            e.hf = function () {
                b.S(j)
            };
            e.fd = function () {
                b.z(j)
            };
            e.ue = function () {
                p && p.$Enable()
            };
            function T(a, c, e) {
                if (b.u(a, "jssor-slider"))return;
                if (!F) {
                    if (a.tagName == "IMG") {
                        y.push(a);
                        if (!b.u(a, "src")) {
                            S = d;
                            a["display-origin"] = b.W(a);
                            b.S(a)
                        }
                    }
                    b.G(a, (b.G(a) || 0) + 1);
                    b.Id(a, 0);
                    b.Jd(a, 0)
                }
                var f = b.yb(a);
                b.a(f, function (f) {
                    var h = f.tagName, i = b.j(f, "u");
                    if (i == "player" && !v) {
                        v = f;
                        if (v.pInstance)Q(); else b.c(v, "dataavailable", Q)
                    }
                    if (i == "caption") {
                        if (c) {
                            b.Wd(f, b.j(f, "to"));
                            b.Xf(f, b.j(f, "bf"));
                            b.j(f, "3d") && b.Wf(f, "preserve-3d")
                        } else if (!b.Od()) {
                            var g = b.Y(f, l, d);
                            b.Yb(g, f, a);
                            b.Jb(f, a);
                            f = g;
                            c = d
                        }
                    } else if (!F && !e && !o) {
                        if (h == "A") {
                            if (b.j(f, "u") == "image")o = b.If(f, "IMG"); else o = b.A(f, "image", d);
                            if (o) {
                                w = f;
                                b.W(w, "block");
                                b.L(w, V);
                                B = b.Y(w, d);
                                b.s(w, "relative");
                                b.Bb(B, 0);
                                b.Z(B, "backgroundColor", "#000")
                            }
                        } else if (h == "IMG" && b.j(f, "u") == "image")o = f;
                        if (o) {
                            o.border = 0;
                            b.L(o, V)
                        }
                    }
                    T(f, c, e + 1)
                })
            }

            e.Ec = function (c, b) {
                var a = u - b;
                bc(L, a)
            };
            e.ib = f;
            n.call(e);
            b.Yf(j, b.j(j, "p"));
            b.ag(j, b.j(j, "po"));
            var N = b.A(j, "thumb", d);
            if (N) {
                e.Bg = b.Y(N);
                b.S(N)
            }
            b.z(j);
            x = b.Y(cb);
            b.G(x, 1e3);
            b.c(j, "click", Z);
            E(d);
            e.Ob = o;
            e.ld = B;
            e.kd = j;
            e.Mb = L = j;
            b.H(L, x);
            h.$On(203, G);
            h.$On(28, eb);
            h.$On(24, bb)
        }

        function zc(y, f, p, q) {
            var a = this, n = 0, u = 0, g, i, e, c, j, t, r, o = C[f];
            m.call(a, 0, 0);
            function v() {
                b.Bc(N);
                fc && j && o.ld && b.H(N, o.ld);
                b.z(N, !j && o.Ob)
            }

            function w() {
                a.Fc()
            }

            function x(b) {
                r = b;
                a.mb();
                a.Fc()
            }

            a.Fc = function () {
                var b = a.Eb();
                if (!B && !O && !r && s == f) {
                    if (!b) {
                        if (g && !j) {
                            j = d;
                            a.od(d);
                            h.k(k.$EVT_SLIDESHOW_START, f, n, u, g, c)
                        }
                        v()
                    }
                    var l, p = k.$EVT_STATE_CHANGE;
                    if (b != c)if (b == e)l = c; else if (b == i)l = e; else if (!b)l = i; else l = a.Zc();
                    h.k(p, f, b, n, i, e, c);
                    var m = P && (!E || F);
                    if (b == c)(e != c && !(E & 12) || m) && o.af(); else(m || b != e) && a.dd(l, w)
                }
            };
            a.Oe = function () {
                e == c && e == a.Eb() && a.E(i)
            };
            a.De = function () {
                A && A.ib == f && A.Ib();
                var b = a.Eb();
                b < c && h.k(k.$EVT_STATE_CHANGE, f, -b - 1, n, i, e, c)
            };
            a.od = function (a) {
                p && b.tb(ib, a && p.Hc.$Outside ? "" : "hidden")
            };
            a.Ec = function (b, a) {
                if (j && a >= g) {
                    j = l;
                    v();
                    o.fd();
                    A.Ib();
                    h.k(k.$EVT_SLIDESHOW_END, f, n, u, g, c)
                }
                h.k(k.$EVT_PROGRESS_CHANGE, f, a, n, i, e, c)
            };
            a.Yc = function (a) {
                if (a && !t) {
                    t = a;
                    a.$On($JssorPlayer$.Ue, x)
                }
            };
            p && a.mc(p);
            g = a.Db();
            a.mc(q);
            i = g + q.vd;
            e = g + q.xd;
            c = a.Db()
        }

        function Mb(a, c, d) {
            b.v(a, c);
            b.B(a, d)
        }

        function bc(c, b) {
            var a = x > 0 ? x : hb, d = Bb * b * (a & 1), e = Cb * b * (a >> 1 & 1);
            Mb(c, d, e)
        }

        function Rb() {
            qb = O;
            Kb = z.Zc();
            G = w.db()
        }

        function ic() {
            Rb();
            if (B || !F && E & 12) {
                z.mb();
                h.k(k.Mg)
            }
        }

        function gc(f) {
            if (!B && (F || !(E & 12)) && !z.$IsPlaying()) {
                var d = w.db(), b = c.ceil(G);
                if (f && c.abs(H) >= a.$MinDragOffsetToSlide) {
                    b = c.ceil(d);
                    b += fb
                }
                if (!(D & 1))b = c.min(r - u, c.max(b, 0));
                var e = c.abs(b - d);
                e = 1 - c.pow(1 - e, 5);
                if (!M && qb)z.Qe(Kb); else if (d == b) {
                    ub.ue();
                    ub.xc()
                } else z.Rb(d, b, e * Xb)
            }
        }

        function Ib(a) {
            !b.j(b.tc(a), "nodrag") && b.fc(a)
        }

        function vc(a) {
            ac(a, 1)
        }

        function ac(a, c) {
            a = b.Ed(a);
            var j = b.tc(a);
            if (!L && !b.j(j, "nodrag") && wc() && (!c || a.touches.length == 1)) {
                B = d;
                Ab = l;
                R = i;
                b.c(f, c ? "touchmove" : "mousemove", Db);
                b.O();
                M = 0;
                ic();
                if (!qb)x = 0;
                if (c) {
                    var g = a.touches[0];
                    vb = g.clientX;
                    wb = g.clientY
                } else {
                    var e = b.Dd(a);
                    vb = e.x;
                    wb = e.y
                }
                H = 0;
                bb = 0;
                fb = 0;
                h.k(k.$EVT_DRAG_START, t(G), G, a)
            }
        }

        function Db(e) {
            if (B) {
                e = b.Ed(e);
                var f;
                if (e.type != "mousemove") {
                    var l = e.touches[0];
                    f = {x: l.clientX, y: l.clientY}
                } else f = b.Dd(e);
                if (f) {
                    var j = f.x - vb, k = f.y - wb;
                    if (c.floor(G) != G)x = x || hb & L;
                    if ((j || k) && !x) {
                        if (L == 3)if (c.abs(k) > c.abs(j))x = 2; else x = 1; else x = L;
                        if (kb && x == 1 && c.abs(k) - c.abs(j) > 3)Ab = d
                    }
                    if (x) {
                        var a = k, i = Cb;
                        if (x == 1) {
                            a = j;
                            i = Bb
                        }
                        if (!(D & 1)) {
                            if (a > 0) {
                                var g = i * s, h = a - g;
                                if (h > 0)a = g + c.sqrt(h) * 5
                            }
                            if (a < 0) {
                                var g = i * (r - u - s), h = -a - g;
                                if (h > 0)a = -g - c.sqrt(h) * 5
                            }
                        }
                        if (H - bb < -2)fb = 0; else if (H - bb > 2)fb = -1;
                        bb = H;
                        H = a;
                        tb = G - H / i / (Z || 1);
                        if (H && x && !Ab) {
                            b.fc(e);
                            if (!O)z.Te(tb); else z.Se(tb)
                        }
                    }
                }
            }
        }

        function nb() {
            tc();
            if (B) {
                B = l;
                b.O();
                b.U(f, "mousemove", Db);
                b.U(f, "touchmove", Db);
                M = H;
                z.mb();
                var a = w.db();
                h.k(k.$EVT_DRAG_END, t(a), a, t(G), G);
                E & 12 && Rb();
                gc(d)
            }
        }

        function mc(c) {
            if (M) {
                b.uf(c);
                var a = b.tc(c);
                while (a && v !== a) {
                    a.tagName == "A" && b.fc(c);
                    try {
                        a = a.parentNode
                    } catch (d) {
                        break
                    }
                }
            }
        }

        function Lb(a) {
            C[s];
            s = t(a);
            ub = C[s];
            Wb(a);
            return s
        }

        function Hc(a, b) {
            x = 0;
            Lb(a);
            h.k(k.$EVT_PARK, t(a), b)
        }

        function Wb(a, c) {
            yb = a;
            b.a(S, function (b) {
                b.zc(t(a), a, c)
            })
        }

        function wc() {
            var b = k.Qc || 0, a = Y;
            if (kb)a & 1 && (a &= 1);
            k.Qc |= a;
            return L = a & ~b
        }

        function tc() {
            if (L) {
                k.Qc &= ~Y;
                L = 0
            }
        }

        function Zb() {
            var a = b.pb();
            b.L(a, V);
            b.s(a, "absolute");
            return a
        }

        function t(a) {
            return (a % r + r) % r
        }

        function nc(b, d) {
            if (d)if (!D) {
                b = c.min(c.max(b + yb, 0), r - u);
                d = l
            } else if (D & 2) {
                b = t(b + yb);
                d = l
            }
            ob(b, a.$SlideDuration, d)
        }

        function zb() {
            b.a(S, function (a) {
                a.Cc(a.Vb.$ChanceToShow <= F)
            })
        }

        function kc() {
            if (!F) {
                F = 1;
                zb();
                if (!B) {
                    E & 12 && gc();
                    E & 3 && C[s].xc()
                }
            }
        }

        function jc() {
            if (F) {
                F = 0;
                zb();
                B || !(E & 12) || ic()
            }
        }

        function lc() {
            V = {Q: K, P: J, $Top: 0, $Left: 0};
            b.a(T, function (a) {
                b.L(a, V);
                b.s(a, "absolute");
                b.tb(a, "hidden");
                b.S(a)
            });
            b.L(cb, V)
        }

        function mb(b, a) {
            ob(b, a, d)
        }

        function ob(h, f, k) {
            if (Tb && (!B && (F || !(E & 12)) || a.$NaviQuitDrag)) {
                O = d;
                B = l;
                z.mb();
                if (f == g)f = Xb;
                var e = Eb.Eb(), b = h;
                if (k) {
                    b = e + h;
                    if (h > 0)b = c.ceil(b); else b = c.floor(b)
                }
                if (D & 2)b = t(b);
                if (!(D & 1))b = c.max(0, c.min(b, r - u));
                var j = (b - e) % r;
                b = e + j;
                var i = e == b ? 0 : f * c.abs(j);
                i = c.min(i, f * u * 1.5);
                z.Rb(e, b, i || 1)
            }
        }

        h.$PlayTo = ob;
        h.$GoTo = function (a) {
            w.E(Lb(a))
        };
        h.$Next = function () {
            mb(1)
        };
        h.$Prev = function () {
            mb(-1)
        };
        h.$Pause = function () {
            P = l
        };
        h.$Play = function () {
            if (!P) {
                P = d;
                C[s] && C[s].xc()
            }
        };
        h.$SetSlideshowTransitions = function (b) {
            a.$SlideshowOptions.$Transitions = b
        };
        h.$SetCaptionTransitions = function (a) {
            I.$Transitions = a;
            I.nc = b.O()
        };
        h.$SlidesCount = function () {
            return T.length
        };
        h.$CurrentIndex = function () {
            return s
        };
        h.$IsAutoPlaying = function () {
            return P
        };
        h.$IsDragging = function () {
            return B
        };
        h.$IsSliding = function () {
            return O
        };
        h.$IsMouseOver = function () {
            return !F
        };
        h.$LastDragSucceded = function () {
            return M
        };
        function X() {
            return b.l(y || p)
        }

        function jb() {
            return b.m(y || p)
        }

        h.$OriginalWidth = h.$GetOriginalWidth = X;
        h.$OriginalHeight = h.$GetOriginalHeight = jb;
        function Gb(c, d) {
            if (c == g)return b.l(p);
            if (!y) {
                var a = b.pb(f);
                b.qd(a, b.qd(p));
                b.cc(a, b.cc(p));
                b.W(a, "block");
                b.s(a, "relative");
                b.B(a, 0);
                b.v(a, 0);
                b.tb(a, "visible");
                y = b.pb(f);
                b.s(y, "absolute");
                b.B(y, 0);
                b.v(y, 0);
                b.l(y, b.l(p));
                b.m(y, b.m(p));
                b.Wd(y, "0 0");
                b.H(y, a);
                var i = b.yb(p);
                b.H(p, y);
                b.Z(p, "backgroundImage", "");
                b.a(i, function (c) {
                    b.H(b.j(c, "noscale") ? p : a, c);
                    b.j(c, "autocenter") && Nb.push(c)
                })
            }
            Z = c / (d ? b.m : b.l)(y);
            b.Zf(y, Z);
            var h = d ? Z * X() : c, e = d ? c : Z * jb();
            b.l(p, h);
            b.m(p, e);
            b.a(Nb, function (a) {
                var c = b.Zb(b.j(a, "autocenter"));
                b.lg(a, c)
            })
        }

        h.$ScaleHeight = h.$GetScaleHeight = function (a) {
            if (a == g)return b.m(p);
            Gb(a, d)
        };
        h.$ScaleWidth = h.$SetScaleWidth = h.$GetScaleWidth = Gb;
        h.Kd = function (a) {
            var d = c.ceil(t(gb / dc)), b = t(a - s + d);
            if (b > u) {
                if (a - s > r / 2)a -= r; else if (a - s <= -r / 2)a += r
            } else a = s + b - d;
            return a
        };
        n.call(h);
        h.$Elmt = p = b.lb(p);
        var a = b.o({
            $FillMode: 0,
            $LazyLoading: 1,
            $ArrowKeyNavigation: 1,
            $StartIndex: 0,
            $AutoPlay: l,
            $Loop: 1,
            $HWA: d,
            $NaviQuitDrag: d,
            $AutoPlaySteps: 1,
            $AutoPlayInterval: 3e3,
            $PauseOnHover: 1,
            $SlideDuration: 500,
            $SlideEasing: e.$EaseOutQuad,
            $MinDragOffsetToSlide: 20,
            $SlideSpacing: 0,
            $Cols: 1,
            $Align: 0,
            $UISearchMode: 1,
            $PlayOrientation: 1,
            $DragOrientation: 1
        }, hc);
        a.$HWA = a.$HWA && b.Nf();
        if (a.$Idle != g)a.$AutoPlayInterval = a.$Idle;
        if (a.$ParkingPosition != g)a.$Align = a.$ParkingPosition;
        var hb = a.$PlayOrientation & 3, xc = (a.$PlayOrientation & 4) / -4 || 1, eb = a.$SlideshowOptions, I = b.o({
            $Class: q,
            $PlayInMode: 1,
            $PlayOutMode: 1,
            $HWA: a.$HWA
        }, a.$CaptionSliderOptions);
        I.$Transitions = I.$Transitions || I.$CaptionTransitions;
        var rb = a.$BulletNavigatorOptions, W = a.$ArrowNavigatorOptions, ab = a.$ThumbnailNavigatorOptions, Q = !a.$UISearchMode, y, v = b.A(p, "slides", Q), cb = b.A(p, "loading", Q) || b.pb(f), Jb = b.A(p, "navigator", Q), ec = b.A(p, "arrowleft", Q), cc = b.A(p, "arrowright", Q), Hb = b.A(p, "thumbnavigator", Q), pc = b.l(v), oc = b.m(v), V, T = [], yc = b.yb(v);
        b.a(yc, function (a) {
            if (a.tagName == "DIV" && !b.j(a, "u"))T.push(a); else b.wb() && b.G(a, (b.G(a) || 0) + 1)
        });
        var s = -1, yb, ub, r = T.length, K = a.$SlideWidth || pc, J = a.$SlideHeight || oc, Yb = a.$SlideSpacing, Bb = K + Yb, Cb = J + Yb, dc = hb & 1 ? Bb : Cb, u = c.min(a.$Cols, r), ib, x, L, Ab, S = [], Sb, Ub, Qb, fc, Gc, P, E = a.$PauseOnHover, qc = a.$AutoPlayInterval, Xb = a.$SlideDuration, sb, db, gb, Tb = u < r, D = Tb ? a.$Loop : 0, Y, M, F = 1, O, B, R, vb = 0, wb = 0, H, bb, fb, Eb, w, U, z, Vb = new sc, Z, Nb = [];
        if (r) {
            if (a.$HWA)Mb = function (a, c, d) {
                b.zb(a, {$TranslateX: c, $TranslateY: d})
            };
            P = a.$AutoPlay;
            h.Vb = hc;
            lc();
            b.u(p, "jssor-slider", d);
            b.G(v, b.G(v) || 0);
            b.s(v, "absolute");
            ib = b.Y(v, d);
            b.Yb(ib, v);
            if (eb) {
                fc = eb.$ShowLink;
                sb = eb.$Class;
                db = u == 1 && r > 1 && sb && (!b.Od() || b.Bd() >= 8)
            }
            gb = db || u >= r || !(D & 1) ? 0 : a.$Align;
            Y = (u > 1 || gb ? hb : -1) & a.$DragOrientation;
            var xb = v, C = [], A, N, Fb = b.Mf(), kb = Fb.Qf, G, qb, Kb, tb;
            Fb.Nd && b.Z(xb, Fb.Nd, ([i, "pan-y", "pan-x", "none"])[Y] || "");
            U = new Dc;
            if (db)A = new sb(Vb, K, J, eb, kb);
            b.H(ib, U.Mb);
            b.tb(v, "hidden");
            N = Zb();
            b.Z(N, "backgroundColor", "#000");
            b.Bb(N, 0);
            b.Yb(N, xb.firstChild, xb);
            for (var pb = 0; pb < T.length; pb++) {
                var Ac = T[pb], Cc = new Bc(Ac, pb);
                C.push(Cc)
            }
            b.S(cb);
            Eb = new Ec;
            z = new rc(Eb, U);
            b.c(v, "click", mc, d);
            b.c(p, "mouseout", b.hc(kc, p));
            b.c(p, "mouseover", b.hc(jc, p));
            if (Y) {
                b.c(v, "mousedown", ac);
                b.c(v, "touchstart", vc);
                b.c(v, "dragstart", Ib);
                b.c(v, "selectstart", Ib);
                b.c(f, "mouseup", nb);
                b.c(f, "touchend", nb);
                b.c(f, "touchcancel", nb);
                b.c(j, "blur", nb)
            }
            E &= kb ? 10 : 5;
            if (Jb && rb) {
                Sb = new rb.$Class(Jb, rb, X(), jb());
                S.push(Sb)
            }
            if (W && ec && cc) {
                W.$Loop = D;
                W.$Cols = u;
                Ub = new W.$Class(ec, cc, W, X(), jb());
                S.push(Ub)
            }
            if (Hb && ab) {
                ab.$StartIndex = a.$StartIndex;
                Qb = new ab.$Class(Hb, ab);
                S.push(Qb)
            }
            b.a(S, function (a) {
                a.qc(r, C, cb);
                a.$On(o.ic, nc)
            });
            b.Z(p, "visibility", "visible");
            Gb(X());
            zb();
            a.$ArrowKeyNavigation && b.c(f, "keydown", function (b) {
                if (b.keyCode == 37)mb(-a.$ArrowKeyNavigation); else b.keyCode == 39 && mb(a.$ArrowKeyNavigation)
            });
            var lb = a.$StartIndex;
            if (!(D & 1))lb = c.max(0, c.min(lb, r - u));
            z.Rb(lb, lb, 0)
        }
    };
    k.$EVT_CLICK = 21;
    k.$EVT_DRAG_START = 22;
    k.$EVT_DRAG_END = 23;
    k.$EVT_SWIPE_START = 24;
    k.$EVT_SWIPE_END = 25;
    k.$EVT_LOAD_START = 26;
    k.$EVT_LOAD_END = 27;
    k.Mg = 28;
    k.$EVT_POSITION_CHANGE = 202;
    k.$EVT_PARK = 203;
    k.$EVT_SLIDESHOW_START = 206;
    k.$EVT_SLIDESHOW_END = 207;
    k.$EVT_PROGRESS_CHANGE = 208;
    k.$EVT_STATE_CHANGE = 209;
    var o = {ic: 1};
    j.$JssorBulletNavigator$ = function (e, C) {
        var f = this;
        n.call(f);
        e = b.lb(e);
        var s, A, z, r, k = 0, a, m, j, w, x, h, g, q, p, B = [], y = [];

        function v(a) {
            a != -1 && y[a].nd(a == k)
        }

        function t(a) {
            f.k(o.ic, a * m)
        }

        f.$Elmt = e;
        f.zc = function (a) {
            if (a != r) {
                var d = k, b = c.floor(a / m);
                k = b;
                r = a;
                v(d);
                v(b)
            }
        };
        f.Cc = function (a) {
            b.z(e, a)
        };
        var u;
        f.qc = function (E) {
            if (!u) {
                s = c.ceil(E / m);
                k = 0;
                var o = q + w, r = p + x, n = c.ceil(s / j) - 1;
                A = q + o * (!h ? n : j - 1);
                z = p + r * (h ? n : j - 1);
                b.l(e, A);
                b.m(e, z);
                for (var f = 0; f < s; f++) {
                    var C = b.Ef();
                    b.pf(C, f + 1);
                    var l = b.md(g, "numbertemplate", C, d);
                    b.s(l, "absolute");
                    var v = f % (n + 1);
                    b.v(l, !h ? o * v : f % j * o);
                    b.B(l, h ? r * v : c.floor(f / (n + 1)) * r);
                    b.H(e, l);
                    B[f] = l;
                    a.$ActionMode & 1 && b.c(l, "click", b.I(i, t, f));
                    a.$ActionMode & 2 && b.c(l, "mouseover", b.hc(b.I(i, t, f), l));
                    y[f] = b.Xb(l)
                }
                u = d
            }
        };
        f.Vb = a = b.o({$SpacingX: 10, $SpacingY: 10, $Orientation: 1, $ActionMode: 1}, C);
        g = b.A(e, "prototype");
        q = b.l(g);
        p = b.m(g);
        b.Jb(g, e);
        m = a.$Steps || 1;
        j = a.$Rows || 1;
        w = a.$SpacingX;
        x = a.$SpacingY;
        h = a.$Orientation - 1;
        a.$Scale == l && b.u(e, "noscale", d);
        a.$AutoCenter && b.u(e, "autocenter", a.$AutoCenter)
    };
    j.$JssorArrowNavigator$ = function (a, g, h) {
        var c = this;
        n.call(c);
        var r, e, f, j;
        b.l(a);
        b.m(a);
        var p, m;

        function k(a) {
            c.k(o.ic, a, d)
        }

        function t(c) {
            b.z(a, c);
            b.z(g, c)
        }

        function s() {
            p.$Enable(h.$Loop || e > 0);
            m.$Enable(h.$Loop || e < r - h.$Cols)
        }

        c.zc = function (b, a, c) {
            if (c)e = a; else {
                e = b;
                s()
            }
        };
        c.Cc = t;
        var q;
        c.qc = function (c) {
            r = c;
            e = 0;
            if (!q) {
                b.c(a, "click", b.I(i, k, -j));
                b.c(g, "click", b.I(i, k, j));
                p = b.Xb(a);
                m = b.Xb(g);
                q = d
            }
        };
        c.Vb = f = b.o({$Steps: 1}, h);
        j = f.$Steps;
        if (f.$Scale == l) {
            b.u(a, "noscale", d);
            b.u(g, "noscale", d)
        }
        if (f.$AutoCenter) {
            b.u(a, "autocenter", f.$AutoCenter);
            b.u(g, "autocenter", f.$AutoCenter)
        }
    };
    j.$JssorThumbnailNavigator$ = function (g, B) {
        var h = this, y, p, a, v = [], z, x, e, q, r, u, t, m, s, f, j;
        n.call(h);
        g = b.lb(g);
        function A(n, f) {
            var g = this, c, m, l;

            function q() {
                m.nd(p == f)
            }

            function k(d) {
                if (d || !s.$LastDragSucceded()) {
                    var a = e - f % e, b = s.Kd((f + a) / e - 1), c = b * e + e - a;
                    h.k(o.ic, c)
                }
            }

            g.ib = f;
            g.Ad = q;
            l = n.Bg || n.Ob || b.pb();
            g.Mb = c = b.md(j, "thumbnailtemplate", l, d);
            m = b.Xb(c);
            a.$ActionMode & 1 && b.c(c, "click", b.I(i, k, 0));
            a.$ActionMode & 2 && b.c(c, "mouseover", b.hc(b.I(i, k, 1), c))
        }

        h.zc = function (b, d, f) {
            var a = p;
            p = b;
            a != -1 && v[a].Ad();
            v[b].Ad();
            !f && s.$PlayTo(s.Kd(c.floor(d / e)))
        };
        h.Cc = function (a) {
            b.z(g, a)
        };
        var w;
        h.qc = function (F, D) {
            if (!w) {
                y = F;
                c.ceil(y / e);
                p = -1;
                m = c.min(m, D.length);
                var h = a.$Orientation & 1, n = u + (u + q) * (e - 1) * (1 - h), j = t + (t + r) * (e - 1) * h, B = n + (n + q) * (m - 1) * h, o = j + (j + r) * (m - 1) * (1 - h);
                b.s(f, "absolute");
                b.tb(f, "hidden");
                a.$AutoCenter & 1 && b.v(f, (z - B) / 2);
                a.$AutoCenter & 2 && b.B(f, (x - o) / 2);
                b.l(f, B);
                b.m(f, o);
                var i = [];
                b.a(D, function (l, g) {
                    var j = new A(l, g), d = j.Mb, a = c.floor(g / e), k = g % e;
                    b.v(d, (u + q) * k * (1 - h));
                    b.B(d, (t + r) * k * h);
                    if (!i[a]) {
                        i[a] = b.pb();
                        b.H(f, i[a])
                    }
                    b.H(i[a], d);
                    v.push(j)
                });
                var E = b.o({
                    $AutoPlay: l,
                    $NaviQuitDrag: l,
                    $SlideWidth: n,
                    $SlideHeight: j,
                    $SlideSpacing: q * h + r * (1 - h),
                    $MinDragOffsetToSlide: 12,
                    $SlideDuration: 200,
                    $PauseOnHover: 1,
                    $PlayOrientation: a.$Orientation,
                    $DragOrientation: a.$NoDrag || a.$DisableDrag ? 0 : a.$Orientation
                }, a);
                s = new k(g, E);
                w = d
            }
        };
        h.Vb = a = b.o({$SpacingX: 0, $SpacingY: 0, $Cols: 1, $Orientation: 1, $AutoCenter: 3, $ActionMode: 1}, B);
        z = b.l(g);
        x = b.m(g);
        f = b.A(g, "slides", d);
        j = b.A(f, "prototype");
        u = b.l(j);
        t = b.m(j);
        b.Jb(j, f);
        e = a.$Rows || 1;
        q = a.$SpacingX;
        r = a.$SpacingY;
        m = a.$Cols;
        a.$Scale == l && b.u(g, "noscale", d)
    };
    function q(e, d, c) {
        var a = this;
        m.call(a, 0, c);
        a.Qd = b.sd;
        a.vd = 0;
        a.xd = c
    }

    j.$JssorCaptionSlideo$ = function (v, j, u) {
        var a = this, w, n = {}, p = j.$Transitions, r = j.$Controls, e = new m(0, 0), t = [], o = [], f = [];
        m.call(a, 0, 0);
        function q(d, c) {
            var a = {};
            b.a(d, function (d, f) {
                var e = n[f];
                if (e) {
                    if (b.Hd(d))d = q(d, c || f == "e"); else if (c)if (b.ac(d))d = w[d];
                    a[e] = d
                }
            });
            return a
        }

        function s(e, c) {
            var a = [], d = b.yb(e);
            b.a(d, function (d) {
                var h = b.j(d, "u") == "caption";
                if (h) {
                    var e = b.j(d, "t"), g = p[b.Zb(e)] || p[e], f = {$Elmt: d, Hc: g};
                    a.push(f)
                }
                if (c < 5)a = a.concat(s(d, c + 1))
            });
            return a
        }

        function l(c, d, e) {
            var a = 0;
            !b.a(c, function (b, c) {
                a = c;
                return b.N > e
            }) && a++;
            c.splice(a, 0, d)
        }

        function z(k, n, e) {
            var a;
            if (r) {
                var j = b.j(k, "c");
                if (j) {
                    var h = r[b.Zb(j)];
                    if (h) {
                        a = {N: h.r, jb: 0, jc: [], Jc: [], ud: 0};
                        l(f, a, h.b)
                    }
                }
            }
            b.a(n, function (g) {
                var f = b.o(d, {}, q(g)), j = b.yc(f.$Easing);
                delete f.$Easing;
                if (f.$Left) {
                    f.C = f.$Left;
                    j.C = j.$Left;
                    delete f.$Left
                }
                if (f.$Top) {
                    f.D = f.$Top;
                    j.D = j.$Top;
                    delete f.$Top
                }
                var p = {
                    $Easing: j,
                    $OriginalWidth: e.Q,
                    $OriginalHeight: e.P
                }, n = new m(g.b, g.d, p, k, e, f), h = t[g.b];
                if (h == i) {
                    h = {N: g.b, jc: []};
                    t[g.b] = h;
                    l(o, h, g.b)
                }
                h.jc.push(n);
                if (a && g.b + g.d > a.N) {
                    a.jb = c.max(a.jb, g.b + g.d);
                    a.Jc.push(n)
                }
                e = b.Zd(e, f)
            });
            if (a && a.Jc.length) {
                var g = new m(a.N, a.jb - a.N, {kc: a.jb - a.N, Yd: d});
                b.a(a.Jc, function (a) {
                    g.eb(a, d)
                });
                g.$Shift(a.jb - a.N);
                a.jc = [g]
            }
            return e
        }

        function y(a) {
            b.a(a, function (f) {
                var a = f.$Elmt, e = b.l(a), d = b.m(a), c = {
                    $Left: b.v(a),
                    $Top: b.B(a),
                    C: 0,
                    D: 0,
                    $Opacity: 1,
                    $ZIndex: b.G(a) || 0,
                    $Rotate: 0,
                    $RotateX: 0,
                    $RotateY: 0,
                    $ScaleX: 1,
                    $ScaleY: 1,
                    $TranslateX: 0,
                    $TranslateY: 0,
                    $TranslateZ: 0,
                    $SkewX: 0,
                    $SkewY: 0,
                    Q: e,
                    P: d,
                    $Clip: {$Top: 0, $Right: e, $Bottom: d, $Left: 0}
                };
                c.gd = c.$Left;
                c.id = c.$Top;
                z(a, f.Hc, c)
            })
        }

        function B(g, f, h) {
            var c = g.b - f;
            if (c) {
                var b = new m(f, c);
                b.eb(e, d);
                b.$Shift(h);
                a.eb(b)
            }
            a.de(g.d);
            return c
        }

        function A(g) {
            var c = e.Ac(), d = 0;
            b.a(g, function (e, g) {
                e = b.o({d: u}, e);
                B(e, c, d);
                c = e.b;
                d += e.d;
                if (!g || e.t == 2) {
                    a.vd = c;
                    a.xd = c + e.d
                }
                b.a(f, function (a) {
                    if (a.jb > e.b)a.ud += e.d
                })
            })
        }

        function g(j, e, a) {
            var f = e.length;
            if (f > 4)for (var k = c.ceil(f / 4), d = 0; d < k; d++) {
                var h = e.slice(d * 4, c.min(d * 4 + 4, f)), i = new m(h[0].N, a || 0);
                g(i, h, a);
                j.eb(i, a)
            } else b.a(e, function (c) {
                b.a(c.jc, function (b) {
                    b.$Shift(c.ud || 0);
                    j.eb(b, a)
                })
            })
        }

        a.Qd = function () {
            a.E(-1, d)
        };
        w = [h.$Swing, h.$Linear, h.$InQuad, h.$OutQuad, h.$InOutQuad, h.$InCubic, h.$OutCubic, h.$InOutCubic, h.$InQuart, h.$OutQuart, h.$InOutQuart, h.$InQuint, h.$OutQuint, h.$InOutQuint, h.$InSine, h.$OutSine, h.$InOutSine, h.$InExpo, h.$OutExpo, h.$InOutExpo, h.$InCirc, h.$OutCirc, h.$InOutCirc, h.$InElastic, h.$OutElastic, h.$InOutElastic, h.$InBack, h.$OutBack, h.$InOutBack, h.$InBounce, h.$OutBounce, h.$InOutBounce, h.$GoBack, h.$InWave, h.$OutWave, h.$OutJump, h.$InJump];
        var C = {
            $Top: "y",
            $Left: "x",
            $Bottom: "m",
            $Right: "t",
            $Rotate: "r",
            $RotateX: "rX",
            $RotateY: "rY",
            $ScaleX: "sX",
            $ScaleY: "sY",
            $TranslateX: "tX",
            $TranslateY: "tY",
            $TranslateZ: "tZ",
            $SkewX: "kX",
            $SkewY: "kY",
            $Opacity: "o",
            $Easing: "e",
            $ZIndex: "i",
            $Clip: "c"
        };
        b.a(C, function (b, a) {
            n[b] = a
        });
        y(s(v, 1));
        g(e, o);
        var x = j.$Breaks || [], k = [].concat(x[b.Zb(b.j(v, "b"))] || []);
        !k.length && k.push({b: e.Db(), d: u});
        A(k);
        g(a, f, a.Db());
        a.E(-1)
    }
})(window, document, Math, null, true, false)