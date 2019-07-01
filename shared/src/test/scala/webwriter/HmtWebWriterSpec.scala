package org.homermultitext.webwriter

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

import org.scalatest.FlatSpec


class HmtWebWriterSpec extends FlatSpec {


  val webWriter = HmtWebWriter("2019zz")

  "An HmtWebWriter" should "compose a release-specific license statement" in {
    println("Here is the license statement for this HmtWebWriter: " + webWriter.license)
    assert(webWriter.license.nonEmpty)
  }


  it should "override the implementation of writeCitableNodeText in the extended CiteHtmlWriter class" in {
    println("Here is the results of formatting a citable node")

    val urn = CtsUrn("urn:cts:greekLit:tlg5026.e3.v1:e3_109v_1")
    val nodeString = """<div n="comment"><p>λιτὰς μὲν τὴν ῤαψῳδίαν καλοῦσιν~ ἐπει δὴ δε οἱ <rs type="ethnic" "urn:cite2:hmt:place.v1:place6">Τρῶες</rs> ἐκ παραδόξου νικῶσι βέλεσι <persName n="urn:cite2:hmt:pers.v1:pers8">Διὸς</persName> οὐκ οἰκείᾳ δυνάμει, παντὶ πόνῳ τὴν τυχήν φυλλάτουσι παρεμβολὴν ἐπὶ τῷ ναυστάθμῳ ποιούμενοι~ ... ⁑</p></div>"""
    val cn = CitableNode(urn,nodeString)
  }
}
