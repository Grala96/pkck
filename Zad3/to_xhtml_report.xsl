<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/root">
      <html>
         <body>
            <h1 align="center">Personal Database</h1>
            <table border="3" align="center">
               <tr>
                  <th>Name</th>
                  <th>Birthday</th>
                  <th>Country</th>
                  <th>City</th>
                  <th>Company</th>
               </tr>
               <xsl:for-each select="personal-data/person">
                  <tr>
                     <td>
                        <xsl:value-of select="name" />
                     </td>
                     <td>
                        <xsl:value-of select="birthday" />
                     </td>
                     <td>
                        <xsl:value-of select="country" />
                     </td>
                     <td>
                        <xsl:value-of select="city" />
                     </td>
                     <td>
                        <xsl:value-of select="work/company" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
            <h1 align="center">Statistics</h1>
            <table border="3" align="center">
               <tr>
                  <th>Name</th>
                  <th>BMI</th>
                  <th>Weight Rate</th>
               </tr>
               <xsl:for-each select="satatistics/bmi-statistics/pernon-bmi">
                  <tr>
                     <td>
                        <xsl:value-of select="name" />
                     </td>
                     <td>
                        <xsl:value-of select="bmi/text()" />
                     </td>
                     <td>
                        <xsl:value-of select="translate(bmi/weight-rate/text(), ' ','')" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
			<h1 align="center">Card Owners</h1>
            <table border="3" align="center">
               <tr>
                  <th>Card</th>
                  <th>Quantity</th>
               </tr>
               <xsl:for-each select="satatistics/card-owners/*">
                  <tr>
                     <td>
                        <xsl:value-of select="local-name()"/>
                     </td>
					 <td>
                        <xsl:value-of select="."/>
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
			<h1 align="center">Ages</h1>
            <table border="3" align="center">
               <tr>
                  <th>Name</th>
                  <th>Value</th>
               </tr>
               <xsl:for-each select="satatistics/age-statistics/*">
                  <tr>
                     <td>
                        <xsl:value-of select="local-name()"/>
                     </td>
					 <td>
                        <xsl:value-of select="."/>
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
		<h1 align="center">Administrators</h1>
            <table border="3" align="center">
               <tr>
                  <th>Name</th>
                  <th>Index</th>
               </tr>
               <xsl:for-each select="administrators/*[name()!='copyright']">
                  <tr>
                     <td>
                        <xsl:value-of select="substring(text(),2,(string-length(text())-2))" />
                     </td>
                     <td>
                        <xsl:value-of select="index" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>