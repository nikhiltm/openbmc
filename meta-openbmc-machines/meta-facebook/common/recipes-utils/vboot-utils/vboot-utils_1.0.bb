SUMMARY = "Verified boot utilities"
DESCRIPTION = "This includes the verified-boot status and update utilities"
SECTION = "base"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=c110423312df5eaf34c8925fc0995bd4"

SRC_URI += " \
    file://COPYING \
    file://pyfdt/__init__.py \
    file://pyfdt/pkcs11.py \
    file://pyfdt/pyfdt.py \
    "

S = "${WORKDIR}"

DEPENDS = "python"
RDEPEND_${PN}-python += "python python-argparse"

PACKAGES += "${PN}-python"

inherit distutils python-dir

do_compile() {
  # No-op
  true
}

do_install() {
  install -d ${D}${PYTHON_SITEPACKAGES_DIR}/pyfdt

  for file in ${S}/pyfdt/*.py; do
    install -m 644 "$file" ${D}${PYTHON_SITEPACKAGES_DIR}/pyfdt/
  done
}

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}"
