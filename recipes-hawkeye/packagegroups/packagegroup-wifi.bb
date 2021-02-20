SUMMARY = "Software components for wireless networking"
PR = "r1"

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
            ${PN}-base \
            ${PN}-ath10k \
            ${PN}-iwlwifi \
            '

RDEPENDS_${PN}-base = "\
            wpa-supplicant \
            "

RDEPENDS_${PN}-ath10k = "\
            ${PN}-base \
            linux-firmware-ath10k \
            kernel-module-ath10k-pci \
            "

RDEPENDS_${PN}-iwlwifi = "\
            ${PN}-base \
            linux-firmware-iwlwifi-8265 \
            kernel-module-iwlwifi \
            kernel-module-iwlmvm \
            "
