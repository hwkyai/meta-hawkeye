# Split iwlwifi-9260 firmware from the iwlwifi-misc catch-all package.
PACKAGES =+ "${PN}-iwlwifi-9260"

LICENSE_${PN}-iwlwifi-9260      = "Firmware-iwlwifi_firmware"
FILES_${PN}-iwlwifi-9260        = "${nonarch_base_libdir}/firmware/iwlwifi-9260-*.ucode"
RDEPENDS_${PN}-iwlwifi-9260     = "${PN}-iwlwifi-license"
