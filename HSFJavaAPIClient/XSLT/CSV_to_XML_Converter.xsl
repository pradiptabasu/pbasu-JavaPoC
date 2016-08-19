<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="fn"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs fn">


	<xsl:variable name="lineSeperator1">
		<xsl:text>
</xsl:text>
	</xsl:variable>

	<xsl:variable name="lineSeperator2" select="'&#10;'" />
	<xsl:variable name="lineSeperator3" select="'&#xA;'" />


	<xsl:variable name="fieldSeperatorTab">
		<xsl:text> </xsl:text>
	</xsl:variable>
	<xsl:variable name="fieldSeperatorComma">
		<xsl:text>,</xsl:text>
	</xsl:variable>

	<xsl:variable name="csvText">
		<xsl:value-of select="'abc,sdf,cfr,ted'" />
	</xsl:variable>

	<xsl:template match="/">
		<TransformedData>
			<originalTransformer>
				<xsl:call-template name="printLine">
					<xsl:with-param name="line"
						select="substring-before($csvText, $lineSeperator1)" />
					<xsl:with-param name="remaining"
						select="substring-after($csvText, $lineSeperator1)" />
				</xsl:call-template>
			</originalTransformer>
			<myCSVtransformer>
				<ListOfAccounts>
				<xsl:call-template name="getCSVDataPradipta">
					<xsl:with-param name="data" select="$csvText" />
					<xsl:with-param name="seperator" select="$fieldSeperatorComma" />
				</xsl:call-template>
				</ListOfAccounts>
			</myCSVtransformer>
		</TransformedData>
	</xsl:template>

	<xsl:template name="printLine">
		<xsl:param name="line" />
		<xsl:param name="remaining" />
		<printlineTemplate>
			<line>
				<xsl:value-of select="$line" />
			</line>
			<remaining>
				<xsl:value-of select="$remaining" />
			</remaining>

			<xsl:call-template name="printFields">
				<xsl:with-param name="line" select="$line" />
			</xsl:call-template>
			<xsl:if test="$remaining != ''">
				<xsl:call-template name="printLine">
					<xsl:with-param name="line"
						select="substring-before($remaining, $lineSeperator1)" />
					<xsl:with-param name="remaining"
						select="substring-after($remaining, $lineSeperator1)" />
				</xsl:call-template>
			</xsl:if>
		</printlineTemplate>
	</xsl:template>

	<xsl:template name="printFields">
		<xsl:param name="line" />
		<!-- render each line and access each field using the getFieldByIndex-template. 
			Example: -->
		<printFieldsTemplate>
			<xsl:call-template name="getFieldByIndex">
				<xsl:with-param name="index" select="1" />
				<xsl:with-param name="line" select="$line" />
			</xsl:call-template>

			<xsl:call-template name="getFieldByIndex">
				<xsl:with-param name="index" select="4" />
				<xsl:with-param name="line" select="$line" />
			</xsl:call-template>
		</printFieldsTemplate>
	</xsl:template>

	<xsl:template name="getFieldByIndex">
		<xsl:param name="index" />
		<xsl:param name="line" />
		<printFieldByIndexTemplate>
			<xsl:choose>
				<xsl:when test="$index > 0">
					<xsl:call-template name="getFieldByIndex">
						<xsl:with-param name="index" select="$index -1" />
						<xsl:with-param name="line" select="substring-after($line, $fieldSeperatorTab)" />
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="substring-before($line,$fieldSeperatorTab)" />
				</xsl:otherwise>
			</xsl:choose>
		</printFieldByIndexTemplate>
	</xsl:template>

	<xsl:template name="getCSVDataPradipta">
		<xsl:param name="data" />
		<xsl:param name="seperator" />
		<xsl:choose>
			<xsl:when test="substring-before($data,$seperator) != '' ">
				<accountName>
					<xsl:value-of select="substring-before($data,$seperator)" />
				</accountName>
				<!-- <receivedInput>
					<xsl:value-of select="$data" />
				</receivedInput>
				<sendingInput>
					<xsl:value-of select="substring-after($data,$seperator)" />
				</sendingInput> -->
				<xsl:call-template name="getCSVDataPradipta">
					<xsl:with-param name="data"
						select="substring-after($data,$seperator)" />
					<xsl:with-param name="seperator" select="$seperator" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<accountName>
					<xsl:value-of select="$data" />
				</accountName>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

</xsl:stylesheet>