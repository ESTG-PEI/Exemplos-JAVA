<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <restaurant>
            <id><xsl:value-of select="/root/restaurant_id/text()"/></id>
            <name><xsl:value-of select="/root/name/text()"/></name>
            <address>
                <zipcode><xsl:value-of select="/root/address/zipcode/text()"/></zipcode>
                <coordinates>
                    <latitude><xsl:value-of select="/root/address/coord[1]/text()"/></latitude>
                    <longitude><xsl:value-of select="/root/address/coord[2]/text()"/></longitude>
                </coordinates>
                <street><xsl:value-of select="/root/address/street/text()"/></street>
                <building><xsl:value-of select="/root/address/building/text()"/></building>
            </address>
            <cuisine><xsl:value-of select="/root/cuisine/text()"/></cuisine>
            <borough><xsl:value-of select="/root/borough/text()"/></borough>
            <grades>
                <xsl:for-each select="root/grades">
                    <grade>
                        <date><xsl:value-of select="newdate/text()"/></date>
                        <score><xsl:value-of select="score/text()"/></score>
                        <value><xsl:value-of select="grade/text()"/></value>
                    </grade>
                </xsl:for-each>
            </grades>
        </restaurant>
    </xsl:template>
</xsl:stylesheet>
