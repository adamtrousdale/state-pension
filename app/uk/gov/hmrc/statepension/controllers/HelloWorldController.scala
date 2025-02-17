/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.statepension.controllers

import play.api.libs.json.Json
import uk.gov.hmrc.play.microservice.controller.BaseController
import uk.gov.hmrc.play.http.logging.MdcLoggingExecutionContext._
import play.api.mvc._
import uk.gov.hmrc.api.controllers.HeaderValidator

import scala.concurrent.Future

case class HelloWorld(message: String)

object HelloWorld {
  implicit val format = Json.format[HelloWorld]
}

object HelloWorldController extends HelloWorldController
object SandboxHelloWorldController extends HelloWorldController

trait HelloWorldController extends BaseController with HeaderValidator {

	def hello(): Action[AnyContent] = Action.async { implicit request =>
		Future.successful(Ok(Json.toJson(HelloWorld("Hello World"))))
	}

}