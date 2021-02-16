SUMMARY = "Software components for wireless networking"
PR = "r1"

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
            packagegroup-wifi-base \
            packagegroup-wifi-ath10k \
            '

RDEPENDS_packagegroup-wifi-base = "\
            wpa-supplicant \
            "

RDEPENDS_packagegroup-wifi-ath10k = "\
            packagegroup-wifi-base \
            linux-firmware-ath10k \
            kernel-module-ath10k-pci \
            "
