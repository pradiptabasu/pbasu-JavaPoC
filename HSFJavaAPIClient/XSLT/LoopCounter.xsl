<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<xsl:param name="seq" select="('1','2','3','4')"/>
		<Root>
			<xsl:variable name="count" as="xs:integer" select="4" />
			<xsl:for-each select="$seq">
				<ABC><xsl:value-of select="position()"/></ABC>
			</xsl:for-each>
		</Root>
	</xsl:template>
</xsl:stylesheet>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:strip-space elements="*"/>

    <xsl:param name="seq" select="('23453','74365','98','653')"/>

    <xsl:template match="/">
        <xsl:for-each select="$seq">
            <xsl:value-of select="concat('Item ',position(),': ',.,'&#xA;')"/>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>