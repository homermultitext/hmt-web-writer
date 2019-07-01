package org.homermultitext.webwriter


import edu.holycross.shot.ohco2._
import edu.furman.classics.citewriter._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** Providing serializations for Homer Multitext Data.
*
* @param release Standard string (yyyyX) identifying a
* published or to-be-published release of the HMT project.
**/
@JSExportAll
case class HmtWebWriter(release: String) extends CiteHtmlWriter {



  def license: String = {
    "This function should compose a release-specific licensing statement.  The current release described here is " + release
  }


  override def writeCitableNodeText(cn:CitableNode):String = {
    "Format text contents of your citable node here"
  }

}
