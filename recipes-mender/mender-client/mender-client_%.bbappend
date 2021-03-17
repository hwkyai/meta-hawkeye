FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://${BPN}_override.conf"

# XXX Work-around for Golang 1.15 deprecating CommonName for
# certificates.
# https://golang.org/doc/go1.15#commonname
#
# This can be removed once the keygen has been updated in
# https://github.com/mendersoftware/integration
#
do_install_append() {
    install -d -m 755 ${D}${systemd_unitdir}/system/${BPN}.service.d
    install -m 644 ${WORKDIR}/${BPN}_override.conf \
        ${D}${systemd_unitdir}/system/${BPN}.service.d/override.conf
}

FILES_${PN} += "${systemd_unitdir}/system/${PN}.service.d"
