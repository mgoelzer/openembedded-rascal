require linux-libc-headers.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://procinfo.h"

S = "${WORKDIR}/linux-${PV}"

do_configure() {
	oe_runmake allnoconfig ARCH=$ARCH
}

do_compile () {
}

do_install() {
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH
}

do_install_append_arm() {
	cp ${WORKDIR}/procinfo.h ${D}${includedir}/asm/
}

SRC_URI[md5sum] = "2e230d005c002fb3d38a3ca07c0200d0"
SRC_URI[sha256sum] = "73c10604c53f1a6ee65ef805293d23903696f8cef864f42d7de9506f0d2ba4c7"
