//package com.minsait.ism.datamanager.repository
//
//import android.content.Context
//import com.google.gson.GsonBuilder
//import com.minsait.ism.common.base.Constants
//import com.minsait.ism.common.base.Constants.HOME_01
//import com.minsait.ism.common.base.Constants.HOME_02
//import com.minsait.ism.common.extensions.getValueForPart
//import com.minsait.ism.models.response.*
//import com.minsait.ism.models.response.smsLogin.ResponseSmsLogin
//import io.reactivex.rxjava3.core.Observable
//import okhttp3.MultipartBody
//import okhttp3.RequestBody
//import okhttp3.ResponseBody
//import retrofit2.Response
//import javax.inject.Inject
//import javax.inject.Named
//
//class MockRepositoryImpl @Inject constructor(
//    @Named("applicationContext") private val context: Context
//) : MockRepository {
//
//    private var gson = GsonBuilder().setDateFormat("MM/dd/yyyy HH:mm:ss")
//        .create()
//
//    private fun readJson(fileName: String): String =
//        context.assets.open(fileName)
//            .bufferedReader()
//            .use { it.readText() }
//
//    override fun getMenu(): Observable<ResponseContentMenu> =
//        createResponse("menu.json")
//
//    override fun registerUser(): Observable<ResponseRegisterUser> =
//        createResponse("altaUsuario.json")
//
//    override fun getUpdates(): Observable<ResponseUpdates> =
//        createResponse("comprobarActualizaciones.json")
//
//    override fun getHomeMenu(level: String): Observable<ResponseHomeMenu> =
//        when (level) {
//            HOME_01 -> createResponse("home.json")
//            HOME_02 -> createResponse("home2.json")
//            else -> createResponse("home3.json")
//        }
//
//    override fun getContentMenu(): Observable<ResponseContentMenu> =
//        createResponse("contentMenu.json")
//
//    override fun getReportMenu(): Observable<ResponseReportMenu> =
//        createResponse("reportMenu.json")
//
//    override fun getUpdatedReports(): Observable<ResponseUpdatedReports> =
//        createResponse("updatedReports.json")
//
//    override fun getDocument(): Observable<ResponseDocument> =
//        createResponse("document.json")
//
//    override fun getNotifications(): Observable<ResponseNotification> =
//        createResponse("notifications.json")
//
//    override fun getDynamicElements(): Observable<ResponseDynamicElements> =
//        createResponse("dynamic_elements.json")
//
//    override fun getPrivacyPolicy(): Observable<ResponsePrivacyPolicy> =
//        createResponse("privacy_policy.json")
//
//    override fun sendPrivacyPolicyConfirmation(): Observable<ResponsePrivacyPolicy> =
//        createResponse("privacy_policy.json")
//
//    override fun getStatusSignedDocuments(cookie: String): Observable<ResponseBox> =
//        if (cookie == "NEXT")
//            createResponse("status_signed_documents_ok.json")
//        else
//            createResponse("status_signed_documents_wait.json")
//
//    override fun getFirtScreen(cookie: String, query: Map<String, String>): Observable<ResponseBox> =
//        when {
//            query.keys.contains(ApiRepository.KEY_AS_BUZON) -> createResponse("box_first_screen.json")
//            query.keys.contains(ApiRepository.KEY_AS_DYNAMIC_SCREEN) -> createResponse("appointment_first_screen.json")
//            query.keys.contains(ApiRepository.KEY_AS_REGISTRO) -> createResponse("registration_first_screen.json")
//            query.keys.contains(ApiRepository.KEY_LOCALIZADOR_OFICINAS) -> createResponse("JSON_LISTA_OFICINAS_MAPA.json")
//
//            else -> createResponse("err_boxscreen.json")
//        }
//
//    override fun getResult(url: String?): Observable<String> =
//        Observable.create { emitter ->
//            emitter.onNext("")
//            emitter.onComplete()
//        }
//
//
//    override fun getNextScreen(cookie: String, body: RequestBody): Observable<ResponseBox> =
//        if (body is MultipartBody)
//            when {
//                body.getValueForPart(ApiRepository.KEY_PANTALLA) == "PANT_DETALLE_REGISTRO" -> createResponse("registration_next_screen.json")
//                body.getValueForPart(ApiRepository.KEY_PANTALLA) == "PANT_SELEC_TRAMITE_REGEL" -> createResponse("registration_first_screen.json")
//                body.getValueForPart(ApiRepository.KEY_PANTALLA) == "ACC_REGISTRO_VOLVER_PANTALLA_FORMULARIO" -> createResponse("registration_first_screen.json")
//                body.getValueForPart(ApiRepository.KEY_PANTALLA) == "PANT_SELEC_PROV" -> createResponse("box_next_screen.json")
//                body.getValueForPart(ApiRepository.KEY_PANTALLA) == "ACC_BUZON_VOLVER_PANTALLA_FORMULARIO" -> createResponse("box_first_screen.json")
//                body.getValueForPart(ApiRepository.KEY_ACTION_SERVICE) == "" -> createResponse("appointment_first_screen.json")
//                body.getValueForPart(ApiRepository.KEY_APPLICATION) == Constants.DYNAMIC_SCREEN_APPLICATION -> createResponse("appointment_next_screen.json")
//                else -> createResponse("err_boxscreen.json")
//            }
//        else
//            createResponse("err_boxscreen.json")
//
//    override fun closeSession(): Observable<ResponseCloseSession> =
//        createResponse("close_session.json")
//
//    override fun getFile(cookie: String, url: String?): Observable<ResponseBody> =
//        Observable.fromAction {
//            ResponseBody.create(null, ByteArray(0))
//        }
//
//    override fun getDownloadedReport(cookie: String, body: Map<String, String>): Observable<ResponseBox> =
//        Observable.fromAction {
//            ResponseBody.create(null, ByteArray(0))
//        }
//
//    override fun getDocumentForUrl(): Observable<ResponseDocument> =
//        createResponse("document.json")
//
//    override fun smsLogin(): Observable<Response<ResponseSmsLogin>> =
//        createResponse("sms_login.json")
//
//    override fun resendLogin(cookie: String, value: String): Observable<Response<ResponseSmsLogin>> =
//        createResponse("sms_resend_login.json")
//
//
//    override fun sendCode(cookie: String, code: String): Observable<Response<ResponseSmsLogin>> =
//        createResponse("sms_send_code.json")
//
//
//    private inline fun <reified T> createResponse(json: String): Observable<T> =
//        Observable.create<T> { emitter ->
//            val result = gson.fromJson(readJson(json), T::class.java)
//            emitter.onNext(result)
//            emitter.onComplete()
//        }
//}