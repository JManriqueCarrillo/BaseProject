//package com.minsait.ism.datamanager.repository
//
//import com.minsait.ism.models.response.*
//import com.minsait.ism.models.response.smsLogin.ResponseSmsLogin
//import io.reactivex.rxjava3.core.Observable
//import okhttp3.RequestBody
//import okhttp3.ResponseBody
//import retrofit2.Response
//
//interface MockRepository {
//
//    fun getMenu(): Observable<ResponseContentMenu>
//
//    fun registerUser(): Observable<ResponseRegisterUser>
//
//    fun getUpdates(): Observable<ResponseUpdates>
//
//    fun getHomeMenu(level: String): Observable<ResponseHomeMenu>
//
//    fun getContentMenu(): Observable<ResponseContentMenu>
//
//    fun getReportMenu(): Observable<ResponseReportMenu>
//
//    fun getUpdatedReports(): Observable<ResponseUpdatedReports>
//
//    fun getDocument(): Observable<ResponseDocument>
//
//    fun getNotifications(): Observable<ResponseNotification>
//
//    fun getDynamicElements(): Observable<ResponseDynamicElements>
//
//    fun getPrivacyPolicy(): Observable<ResponsePrivacyPolicy>
//
//    fun sendPrivacyPolicyConfirmation(): Observable<ResponsePrivacyPolicy>
//
//    fun getStatusSignedDocuments(cookie: String): Observable<ResponseBox>
//
//    fun getNextScreen(cookie: String, body: RequestBody): Observable<ResponseBox>
//
//    fun getFirtScreen(cookie: String, query: Map<String, String>): Observable<ResponseBox>
//
//    fun getResult(url: String?) : Observable<String>
//
//    fun closeSession(): Observable<ResponseCloseSession>
//
//    fun getFile(cookie: String, url: String?): Observable<ResponseBody>
//
//    fun smsLogin(): Observable<Response<ResponseSmsLogin>>
//
//    fun resendLogin(cookie: String, value: String): Observable<Response<ResponseSmsLogin>>
//
//    fun sendCode(cookie: String, code: String): Observable<Response<ResponseSmsLogin>>
//
//    fun getDownloadedReport(cookie: String, body: Map<String, String>): Observable<ResponseBox>
//
//    fun getDocumentForUrl() : Observable<ResponseDocument>
//}