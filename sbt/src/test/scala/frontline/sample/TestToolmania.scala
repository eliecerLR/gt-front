
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class TestToolmania extends Simulation {

	val httpProtocol = http
		.baseUrl("https://toolmania.cl")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:84.0) Gecko/20100101 Firefox/84.0")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_9 = Map(
		"Origin" -> "https://toolmania.cl",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_12 = Map(
		"Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity")

	val headers_13 = Map("Accept" -> "image/webp,*/*")

	val headers_16 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "https://toolmania.cl",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_17 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "https://toolmania.cl",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://toolmania.cl"

	val scn = scenario("TestToolmania")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(7)
		.exec(http("request_1")
			.get("/")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_2")
			.get("/ofertas-instrumentos-de-medicion-2717")
			.headers(headers_1)
			.resources(http("request_3")
			.get("/ofertas-equipos-y-maquinaria-2670")
			.headers(headers_1),
            http("request_4")
			.get("/ofertas-elementos-de-proteccion-personal-epp-2806")
			.headers(headers_1),
            http("request_5")
			.get("/ofertas-herramientas-inalambricas-2664")
			.headers(headers_1),
            http("request_6")
			.get("/ofertas-herramientas-electricas-2656")
			.headers(headers_1),
            http("request_7")
			.get("/ofertas-accesorios-2737")
			.headers(headers_1)))
		.pause(18)
		.exec(http("request_8")
			.get("/zapatos-de-seguridad/zapatos-de-seguridad-punta-de-composite-n36-al-46-cooper-atox-120416-14581.html")
			.headers(headers_1))
		.pause(7)
		.exec(http("request_9")
			.post("/carrito")
			.headers(headers_9)
			.formParam("token", "95ad517567645dd17d6cc0dc3aa1c88b")
			.formParam("id_product", "14581")
			.formParam("id_customization", "0")
			.formParam("qty", "1")
			.formParam("add", ""))
		.pause(5)
		.exec(http("request_10")
			.get("/taladros-inalambricos/dewalt-taladro-rot-compacto-inalambrico-20v-litio-ion-cod-dcd780c2-b2-439.html")
			.headers(headers_1))
		.pause(6)
		.exec(http("request_11")
			.get(uri1 + "/carros-de-limpieza-1686")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_12")
			.get(uri1 + "/themes/toolmania/modules/ets_megamenu/views/fonts/fontawesome-webfont.woff2?v=4.7.0")
			.headers(headers_12)
			.resources(http("request_13")
			.get(uri1 + "/img/favicon.ico?1607724527")
			.headers(headers_13)))
		.pause(2)
		.exec(http("request_14")
			.get(uri1 + "/carros-de-limpieza/carrocarro-estrujador-rojo-35-lts-luster-7021000028071-10384.html")
			.headers(headers_1))
		.pause(12)
		.exec(http("request_15")
			.get("/kit-accesorios/makita-set-impact-gold-torsion-10-piezas-cod-b-39512-10-1618.html")
			.headers(headers_1))
		.pause(31)
		.exec(http("request_16")
			.post("/carrito")
			.headers(headers_16)
			.formParam("token", "95ad517567645dd17d6cc0dc3aa1c88b")
			.formParam("id_product", "1618")
			.formParam("id_customization", "0")
			.formParam("qty", "1")
			.formParam("add", "1")
			.formParam("action", "update")
			.resources(http("request_17")
			.post("/module/ps_shoppingcart/ajax")
			.headers(headers_17)
			.formParam("id_product_attribute", "0")
			.formParam("id_product", "1618")
			.formParam("action", "add-to-cart"),
            http("request_18")
			.post("/kit-accesorios/makita-set-impact-gold-torsion-10-piezas-cod-b-39512-10-1618.html")
			.headers(headers_17)
			.formParam("id_product_attribute", "0")
			.formParam("id_product", "1618"),
            http("request_19")
			.post("/index.php?controller=product?token=95ad517567645dd17d6cc0dc3aa1c88b&id_product=1618&id_customization=0&qty=1")
			.headers(headers_16)
			.formParam("ajax", "1")
			.formParam("action", "refresh")
			.formParam("quantity_wanted", "1")))
		.pause(2)
		.exec(http("request_20")
			.get("/pedido")
			.headers(headers_1))

	setUp(scn.inject(atOnceUsers(35))).protocols(httpProtocol)
}