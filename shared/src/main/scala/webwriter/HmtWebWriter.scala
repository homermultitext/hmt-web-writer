package org.homermultitext.webwriter


import edu.holycross.shot.ohco2._
import edu.furman.classics.citewriter._
import org.homermultitext.edmodel._

import scala.xml._

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


  /** Format the HTML representation of an HmtToken.
  *
  * @param tkn Token to format.
  */
  def writeHmtToken(tkn: HmtToken) : String =  {
    // Default to using Leiden-convention String
    // for diplomatic reading of text:
    tkn.leidenDiplomatic
  }

  /** Format HTML representation of the text of a CitableNode
  * by catting together the HTML representation of each HmtToken.
  *
  * @param cn The CitableNode for which we will format
  * the text contents in HTML.
  */
  override def writeCitableNodeText(cn: CitableNode): String = {
    val n = XML.loadString(cn.text)
    val settings = TokenSettings(cn.urn, LexicalToken)
    val tokens = TeiReader.collectTokens(n, settings)



    val htmlStrings = for (t <- tokens) yield writeHmtToken(t)
    htmlStrings.mkString(" ")

  }

}
