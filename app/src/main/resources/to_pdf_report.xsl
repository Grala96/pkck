<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
   <xsl:output method="xml" indent="yes" encoding="iso-8859-1" />
   <xsl:template match="/">
      <fo:root>
         <fo:layout-master-set>
            <fo:simple-page-master master-name="A4" page-height="11in" page-width="8.5in" margin-top=".5in" margin-bottom=".5in" margin-left=".5in" margin-right=".5in">
               <fo:region-body margin-top="1in" margin-bottom="1in" />
               <fo:region-before extent=".5in" />
               <fo:region-after extent=".5in" />
            </fo:simple-page-master>
         </fo:layout-master-set>
         <fo:page-sequence master-reference="A4">
            <fo:static-content flow-name="xsl-region-before" text-align="center">
               <fo:block font-size="20pt" font-weight="bold">Personal Database</fo:block>
            </fo:static-content>
            <fo:flow flow-name="xsl-region-body">
               <fo:block text-align="center" margin="10px">Person List</fo:block>
               <fo:table table-layout="fixed" border-width="1mm" border-style="solid" font-size="8px" break-after="page">
                  <fo:table-column column-width="120px" />
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-column column-width="150px" />
                  <fo:table-header text-align="center" background-color="silver">
                     <fo:table-row>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">First Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Middle Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Last Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Birthday</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Position</fo:block>
                        </fo:table-cell>
                     </fo:table-row>
                  </fo:table-header>
                  <fo:table-body>
                     <xsl:for-each select="/database/people/person">
                        <fo:table-row>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="firstname" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="middlename" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="lastname" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="birthday" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="work/position" />
                              </fo:block>
                           </fo:table-cell>
                        </fo:table-row>
                     </xsl:for-each>
                  </fo:table-body>
               </fo:table>
            </fo:flow>
         </fo:page-sequence>
      </fo:root>
   </xsl:template>
</xsl:stylesheet>
