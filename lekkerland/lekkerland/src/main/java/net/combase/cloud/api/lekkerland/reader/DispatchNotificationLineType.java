package net.combase.cloud.api.lekkerland.reader;

public enum DispatchNotificationLineType {
	A10_001_RECORDART(3),
	A10_002_DATENART(3),
	A10_003_VERSION(3),
	A10_004_PARTNERART(2),
	A10_005_PARTNERNUMMER(13),
	A10_006_UEBERMITTLUNGSART(1),
	A10_007_PAKETNUMMER(6),
	A10_008_ZIP_FLAG(3),
	A10_009_RESTART_NUMMER(2),
	A10_010_ABSENDENDES_SYSTEM(1),
	A10_011_EMPFANGENDES_SYSTEM(1),
	S01_001_RECORDART(3),
	S01_002_DATENART(3),
	S01_003_VERSION(3),
	S01_004_PARTNERNUMMER(13),
	S01_005_ERSTELLUNGSDATUM(8),
	S01_006_ERSTELLUNGSZEIT(6),
	S01_007_ANZAHL_DATENSAETZE(6),
	S01_008_LAUFNUMMER(6),
	S01_009_MAILADRESSE(70),
	L10_001_RECORDART(3),
	L10_002_LIEFERDATUM(8),
	L10_003_LIEFERSCHEIN_NUMMER(6),
	L10_004_LIEFERSCHEINART(1),
	L10_005_LIEFERSCHEIN_NUMMER_ALLES(18),
	L20_001_RECORDART(3),
	L20_002_POSITIONSNUMMER(4),
	L20_003_ARTIKEL_NR_BESTELLT(20),
	L20_004_EAN_NR_BESTELLT(20),
	L20_005_MENGE_BESTELLT(4),
	L20_006_ARTIKEL_NR_GELIEFERT(20),
	L20_007_EAN_NR_LE_GELIEFERT(20),
	L20_008_EAN_NR_VE_GELIEFERT(20),
	L20_009_MENGE_GELIEFERT(7),
	L20_010_GEWICHTSCODE(1),
	L20_011_FEHLLIEFERCODE(2),
	L20_012_ARTIKELART(1),
	L20_013_AKTIONSKENNZEICHEN(1),
	L20_014_NETTOCODE(1),
	L20_015_TEKTURCODE(1),
	L20_016_VE_LE(4),
	L20_017_MWST_FLAG(1),
	L20_018_ABGABEPREIS_NETTO_(7),
	L20_019_CODE_PREISEINGABE_MAN(1),
	L20_020_VERKAUFSPREIS_(6),
	L20_021_ABGABEPREIS_BRUTTO(7),
	L20_022_MUTATIONSCODE(1),
	L20_023_USEGO_STAMMNUMMER(20),
	L20_024_ARTIKELTEXT(30),
	L20_025_LIEFEREINHEIT(2),
	L20_026_VERKAUFSEINHEIT(2),
	L20_027_INHALT_EINHEIT(3),
	L20_028_INHALT(7),
	L20_029_PFAND(20),
	L20_030_HAUPTGRUPPE(4),
	L20_031_WARENGRUPPE(4),
	L20_032_ORDERSATZVERCODUNG(1),
	L20_033_TIEFPREISCODE(1),
	L20_034_EIGENMARKENCODE(1),
	L20_035_PFLICHTSORTIMENT(1),
	L20_036_MATERIALKLASSE(4),
	L20_037_BESTELLNUMMER_KUNDE(10),
	L20_038_ERSATZARTIKELNUMMER(20),
	L20_039_BESTELLNUMMER_KD(18),
	L20_040_KUNDENAUFTRAGSNUMMER_LL(10),
	L20_041_POSITION_KD_AUFTRAG_LL(4),
	L20_042_STABILE_ARTIKELNUMMER(20),
	L20_043_MWST_SATZ(10),
	L20_044_MWST_BETRAG(10),
	L20_045_LIEFEREINHEIT(4),
	L20_046_VERKAUFSEINHEIT(4),
	L20_047_MHD(8),
	L25_001_RECORDART(3),
	L25_002_ARTIKELNUMMER(20),
	L25_003_EAN_NUMMER_VE(20),
	L25_004_ID_DER_HIERARCHIESTUFE(3),
	L25_005_TEXTKUERZEL_DER_STUFE(2),
	L25_006_UMRFAKTOR_HOEHERE_STUFE(8),
	L25_007_TEXTKUERZEL_HOEHERE_STUFE(2),
	L25_008_ARTIKELTEXT(30),
	L25_009_VERKAUFSPREIS(7),
	L25_010_TEXTKUERZEL_DER_STUFE(4),
	L25_011_TEXTKUERZEL_HOEHERE_STUFE(4),
	L30_001_RECORDART(3),
	L30_002_ARTIKELNUMMER(20),
	L30_003_EAN_NUMMER_VE(20),
	L30_004_HIERARCHIESTUFE(3),
	E01_001_RECORDART(3),
	E01_002_DATENART(3),
	E01_003_VERSION(3),
	E01_004_PARTNERNUMMER(13),
	E01_005_ERSTELLUNGSDATUM(8),
	E01_006_ERSTELLUNGSZEIT(6),
	E01_007_ANZAHL_DATENSAETZE(6),
	E01_008_LAUFNUMMER(6),
	Z90_001_RECORDART(3),
	Z90_002_DATENART(3),
	Z90_003_VERSION(3),
	Z90_004_PARTNERART(2),
	Z90_005_PARTNERNUMMER(13),
	Z90_006_UEBERMITTLUNGSART(1),
	Z90_007_PAKETNUMMER(6),
	Z90_008_ZIP_FLAG(3),
	Z90_009_RESTART_NUMMER(2),
	Z90_010_ABSENDENDES_SYSTEM(1),
	Z90_011_EMPFANGENDES_SYSTEM(1);
	
	
	private final int code;

	private DispatchNotificationLineType(final int code)
	{
		this.code = code;
	}


	public int getCode()
	{
		return this.code;
	}
}
