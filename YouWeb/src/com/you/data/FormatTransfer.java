package com.you.data;

public class FormatTransfer {
	/**
	 * * 参考http://blog.csdn.net/jiangxinyu/article/details/8165064
	 * * 将int转为低字节在前，高字节在后的byte数组 * @param n int * @return byte[]
	 */
	public static byte[] toLH(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 &0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}

//	/** * 将int转为高字节在前，低字节在后的byte数组 * @param n int * @return byte[] */
//	public static byte[] toHH(int n) {
//		byte[] b = new byte[4];
//		b[3] = (byte) (n & 0xff);
//		b[2] = (byte) (n >> 8 & 0xff);
//		b[1] = (byte) (n >> 16 &
//
//		0xff);
//		b[0] = (byte) (n >> 24 & 0xff);
//		return b;
//	}
	
	/** * 将高字节数组转换为int * @param b byte[] * @return int */
//	public static int hBytesToInt(byte[] b) {
//		int s =0;
//		for (int i = 0; i < 3; i++) {
//			if ( b>=0 ) {
//				s = s + b;
//			} else {
//				s = s + 256 + b;
//			}
//			s = s * 256;
//		}
//		if (b[3] >= 0) {
//			s = s + b[3];
//		} else {
//			s = s + 256 + b[3];
//		}
//		return s;
//	}

	/** * 将低字节数组转换为int * @param b byte[] * @return int */
	public static int lBytesToInt(byte[] b) {
		int s =

		0;
		for (int i = 0; i < 3; i++) {
			if (b[3 - i] >= 0) {
				s = s + b[3 - i];
			} else {
				s = s + 256 + b[3 - i];
			}

			s = s * 256;
		}
		if (b[0] >= 0) {
			s = s + b[0];
		} else {
			s = s + 256 + b[0];
		}
		return s;
	}


	
	/** * 合并两个字节数组 */
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

}


